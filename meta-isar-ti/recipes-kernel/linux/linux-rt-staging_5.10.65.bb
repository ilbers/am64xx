require recipes-kernel/linux/linux-custom.inc

BRANCH = "ti-rt-linux-5.10.y"

SRC_URI += " \
    git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git;branch=${BRANCH} \
    file://ti-defconfig"

SRCREV = "541ec9a6995c3dd881d6f0b63cc714a08ded457d"

S = "${WORKDIR}/git"

# Specify defconfig to use, usually is set per-machine
KERNEL_DEFCONFIG = "ti-defconfig"

# String to be attached to the kernel version
LINUX_VERSION_EXTENSION = "-isar"

do_prepare_build_append() {
	# Create additional symlinks to use with default U-Boot environment
	echo "/boot/vmlinux-${PV}-rt53${LINUX_VERSION_EXTENSION} /boot/Image" > ${S}/debian/linux-image-rt-staging.links
	echo "/usr/lib/linux-image-${PV}-rt53${LINUX_VERSION_EXTENSION}/ti/${DTB_FILES} /boot/${DTB_FILES}" >> ${S}/debian/linux-image-rt-staging.links
}
