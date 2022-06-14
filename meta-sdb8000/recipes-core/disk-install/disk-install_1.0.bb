DESCRIPTION = "sdb8000 initial emmc preparation and image installation"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
	file://disk-install.sh \
"

RDEPENDS:${PN} += "blockdev-init nvram"

do_install () {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/disk-install.sh ${D}${sbindir}/disk-install
}

COMPATIBLE_MACHINE = "sdb8000"
