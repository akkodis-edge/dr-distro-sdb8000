DESCRIPTION = "Cog systemd launcher"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SRC_URI += " \
	file://cog-launch.service \
	file://cog-default \
	file://80-cog \
"

RDEPENDS:${PN} += "cog"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/cog-launch.service ${D}${systemd_system_unitdir}/cog-launch.service
    install -d ${D}/${sysconfdir}/default
    install -m 0644 ${WORKDIR}/cog-default ${D}/${sysconfdir}/default/cog
    install -d ${D}/${sysconfdir}/NetworkManager/dispatcher.d
    install -m 0755 ${WORKDIR}/80-cog ${D}/${sysconfdir}/NetworkManager/dispatcher.d/80-cog
}

SYSTEMD_SERVICE:${PN} += "cog-launch.service"
