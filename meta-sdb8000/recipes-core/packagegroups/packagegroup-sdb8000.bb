SUMMARY = "Standard packages for sdb8000"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-service \
	packagegroup-sdb8000-browser \
"

RDEPENDS:packagegroup-sdb8000-base = "\
	flash-uboot \
	image-tools \
	backlightctl \
	mount-data \
"

RDEPENDS:packagegroup-sdb8000-service = "\
	firmware-i210 \
	flash-i210 \
	flash-fuse-imx8mm \
	i2c-tools \
	packagegroup-datarespons-test-core \
	packagegroup-datarespons-test-graphics \
	packagegroup-datarespons-test-touch \
	phytool \
	optee-test \
	image-tools-autocommit \
"

RDEPENDS:packagegroup-sdb8000-browser = "\
	cog \
	cog-launch \
"
