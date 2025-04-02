DESCRIPTION = "Image installation configuration file"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
	file://image-install.in \
	file://image-install-status.sh \
"

do_install () {
    install -d ${D}${sysconfdir}/default
    sed -e 's:@bindir@:${bindir}:g' ${WORKDIR}/image-install.in > ${WORKDIR}/image-install
    install -m 0644 ${WORKDIR}/image-install ${D}${sysconfdir}/default/
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/image-install-status.sh ${D}${sbindir}/image-install-status
}

FILES:${PN} += "${sysconfdir}/default/image-install"

COMPATIBLE_MACHINE = "sdb8000"
