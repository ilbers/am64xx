inherit dpkg-raw

SRC_URI = "file://Image \
           file://k3-am642-sk.dtb"

do_install() {
    install -v -d ${D}/boot/
    install -v -m 644 ${WORKDIR}/Image ${D}/boot/
    install -v -m 644 ${WORKDIR}/k3-am642-sk.dtb ${D}/boot/
}
