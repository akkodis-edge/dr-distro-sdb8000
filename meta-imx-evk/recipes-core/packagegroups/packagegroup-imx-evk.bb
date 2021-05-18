SUMMARY = "Standard packages for imx-evk"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	${@bb.utils.contains('MACHINE_FEATURES', 'screen', 'packagegroup-imx-evk-browser', '',d)} \
	packagegroup-imx-evk-base \
"

RDEPENDS_packagegroup-imx-evk-base = "\
	flash-uboot \
	blockdev-init \
"

RDEPENDS_packagegroup-imx-evk-browser = "\
	chromium-ozone-wayland \
"