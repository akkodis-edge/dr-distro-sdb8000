DESCRIPTION = "udev rules for sdb8000"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://10-touch.rules"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

RDEPENDS:${PN} += "nvram-touch-calibration"

do_install () {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${S}/10-touch.rules ${D}${sysconfdir}/udev/rules.d/
}
