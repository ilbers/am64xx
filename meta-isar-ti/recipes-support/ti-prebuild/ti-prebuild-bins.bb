SRC_URI = "file://bl31.bin \
           file://bl32.bin \
           file://tiboot3.bin \
           file://tispl.bin \
           file://u-boot.img \
           file://uEnv.txt"

inherit dpkg-raw

# Just copy files, no building will be done
do_install() {
    install -v -d ${D}/usr/lib/ti-prebuild/
    install -v -m 644 ${WORKDIR}/bl31.bin ${D}/usr/lib/ti-prebuild/
    install -v -m 644 ${WORKDIR}/bl32.bin ${D}/usr/lib/ti-prebuild/
    install -v -m 644 ${WORKDIR}/tiboot3.bin ${D}/usr/lib/ti-prebuild/
    install -v -m 644 ${WORKDIR}/tispl.bin ${D}/usr/lib/ti-prebuild/
    install -v -m 644 ${WORKDIR}/u-boot.img ${D}/usr/lib/ti-prebuild/
    install -v -m 644 ${WORKDIR}/uEnv.txt ${D}/usr/lib/ti-prebuild/
}
