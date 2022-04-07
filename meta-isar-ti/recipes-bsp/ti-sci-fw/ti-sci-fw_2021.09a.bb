inherit dpkg

BRANCH = "ti-linux-firmware"

# We use custom debian/rules file to change build, test and install steps
SRC_URI = "git://git.ti.com/processor-firmware/ti-linux-firmware.git;branch=${BRANCH} \
           git://git.ti.com/k3-image-gen/k3-image-gen.git;destsuffix=git/imggen;name=imggen \
           file://rules"

SRCREV = "c96a734a059889e571dcf30c0638157c690a6e6e"
SRCREV_imggen = "489c767a153ff26e9230746e04dd4b1ad0809901"

S = "${WORKDIR}/git"

DEPENDS = "u-boot-ti-staging"

DEBIAN_BUILD_DEPENDS = "openssl, u-boot-tools, u-boot-${MACHINE}"

# This will create debianization
# Will use custom rules file if exist or create default one
do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    deb_debianize
}
