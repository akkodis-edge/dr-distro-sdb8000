SUMMARY = "Browser for sdb8000"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-sdb8000-browser \
"

RDEPENDS_packagegroup-sdb8000-browser = "\
	cog \
	cog-launch \
"