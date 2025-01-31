SUMMARY = "Standard packages for sdb8000"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-browser \
"

RDEPENDS:packagegroup-sdb8000-base = "\
	flash-uboot \
	image-tools \
	image-tools-swap-root \
	backlightctl \
	mount-data \
"

RDEPENDS:packagegroup-sdb8000-browser = "\
	cog \
	cog-launch \
"
