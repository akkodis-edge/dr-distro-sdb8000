SUMMARY = "Standard packages for sdb8000"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-test \
	packagegroup-sdb8000-factory \
"

RDEPENDS:packagegroup-sdb8000-base = "\
	flash-uboot \
	swap-root \
	nvram \
	libgpiod-tools \
	backlightctl \
"

RDEPENDS:packagegroup-sdb8000-factory = "\
	firmware-i210 \
	flash-i210 \
	disk-install \
	flash-fuse-imx8mm \
"

RDEPENDS:packagegroup-sdb8000-test = "\
	strace \
	i2c-tools \
	packagegroup-datarespons-test \
	phytool \
	optee-test \
	stress-ng \
"
