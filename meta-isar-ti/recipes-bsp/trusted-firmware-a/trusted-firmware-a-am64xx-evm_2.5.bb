require recipes-bsp/trusted-firmware-a/trusted-firmware-a-custom.inc

BRANCH = "ti-atf"

SRC_URI += "git://git.ti.com/atf/arm-trusted-firmware.git;branch=${BRANCH}"

SRCREV = "0693f356eb2a25adf8758d98058120bed082cc73"

S = "${WORKDIR}/git"

# Defines for platform selection
TF_A_PLATFORM = "k3"
TF_A_EXTRA_BUILDARGS = "TARGET_BOARD=lite SPD=opteed"
TF_A_BINARIES = "lite/release/bl31.bin"
