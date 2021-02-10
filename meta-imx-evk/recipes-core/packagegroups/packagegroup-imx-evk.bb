SUMMARY = "Standard packages for imx-evk"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-imx-evk-base \
	packagegroup-imx-evk-browser \
"

RDEPENDS_packagegroup-imx-evk-base = "\
	flash-uboot \
"

RDEPENDS_packagegroup-imx-evk-browser = "\
	chromium-ozone-wayland \
"