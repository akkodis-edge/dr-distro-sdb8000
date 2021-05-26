SUMMARY = "Standard packages for sdb8000"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	${@bb.utils.contains('MACHINE_FEATURES', 'screen', 'packagegroup-sdb8000-browser', '',d)} \
	packagegroup-sdb8000-base \
"

RDEPENDS_packagegroup-sdb8000-base = "\
	flash-uboot \
	blockdev-init \
"

RDEPENDS_packagegroup-sdb8000-browser = "\
	chromium-ozone-wayland \
"