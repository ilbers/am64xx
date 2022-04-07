require recipes-bsp/u-boot/u-boot-custom.inc

BRANCH = "ti-u-boot-2021.01"

SRC_URI += " git://git.ti.com/ti-u-boot/ti-u-boot.git;branch=${BRANCH}"

SRCREV = "15769936a559b1840f50b83f94ee0c636b245001"

# Build those packages first
DEPENDS = "ti-prebuild-bins trusted-firmware-a-${MACHINE}"

# Install those packages into buildchroot before build
DEBIAN_BUILD_DEPENDS = "bc, bison, flex, device-tree-compiler, git, ti-prebuild-bins, trusted-firmware-a-${MACHINE}"

S = "${WORKDIR}/git"

# We need additional files to be included into deb
# So can just add them into .install file
do_prepare_build_append() {
    echo "tispl.bin /usr/lib/u-boot/${MACHINE}" >> \
        ${S}/debian/u-boot-${MACHINE}.install
    echo "spl/u-boot-spl.bin /usr/lib/u-boot/${MACHINE}" >> \
        ${S}/debian/u-boot-${MACHINE}.install
    echo "u-boot.img /usr/lib/u-boot/${MACHINE}" >> \
        ${S}/debian/u-boot-${MACHINE}.install
}

# Provide paths for external bins
# But exports like that should be better done with custom rules file + templates
dpkg_runbuild_prepend() {
    export ATF="/usr/lib/trusted-firmware-a/${MACHINE}/bl31.bin"
    export TEE="/usr/lib/ti-prebuild/bl32.bin"
}
