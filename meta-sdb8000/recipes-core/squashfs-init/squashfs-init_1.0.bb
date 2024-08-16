DESCRIPTION = "Locate squashfs for chroot"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://init"

do_install () {
	install -m 0755 ${WORKDIR}/init ${D}
}

RDEPENDS:${PN} = " \
	kernel-module-squashfs \
	kernel-module-overlay \
	busybox \
	squashfs-tools \
	util-linux-blkid \
"

FILES:${PN} = "/init"
