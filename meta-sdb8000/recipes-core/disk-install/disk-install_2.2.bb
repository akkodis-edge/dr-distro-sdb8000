DESCRIPTION = "sdb8000 initial emmc preparation and image installation"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
	file://disk-install-linux.sh \
	file://disk-install-aosp.sh \
"

RDEPENDS:${PN} = "image-tools nvram bash"

do_install () {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/disk-install-linux.sh ${D}${sbindir}/disk-install-linux
    install -m 0755 ${WORKDIR}/disk-install-aosp.sh ${D}${sbindir}/disk-install-aosp
}

COMPATIBLE_MACHINE = "sdb8000"
