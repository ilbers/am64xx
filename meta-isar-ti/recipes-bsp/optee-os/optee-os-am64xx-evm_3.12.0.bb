require recipes-bsp/optee-os/optee-os-custom.inc

SRC_URI += "git://github.com/OP-TEE/optee_os.git"

SRCREV = "3d47a131bca1d9ed511bfd516aa5e70269e12c1d"

S = "${WORKDIR}/git"

# Select platform
OPTEE_PLATFORM = "k3-am65x"
# Set build params
OPTEE_EXTRA_BUILDARGS = " \
    CFG_ARM64_core=y \
    NOWERROR=1 V=1 ta-targets=ta_arm64 \
    CFG_TEE_CORE_LOG_LEVEL=2"
