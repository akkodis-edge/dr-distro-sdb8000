DESCRIPTION = "Cog systemd launcher"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SRC_URI += " \
	file://cog-launch.service \
	file://cog-default \
"

RDEPENDS_${PN} += "cog"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/cog-launch.service ${D}${systemd_system_unitdir}/cog-launch.service
    install -d ${D}/${sysconfdir}/default
    install -m 0644 ${WORKDIR}/cog-default ${D}/${sysconfdir}/default/cog
}

SYSTEMD_SERVICE_${PN} += "cog-launch.service"
