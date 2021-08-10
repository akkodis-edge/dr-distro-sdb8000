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

RDEPENDS_packagegroup-sdb8000-base = "\
	flash-uboot \
	swap-root \
	nvram \
"

RDEPENDS_packagegroup-sdb8000-factory = "\
	firmware-i210 \
	flash-i210 \
	disk-install \
	flash-fuse-imx8mm \
"

RDEPENDS_packagegroup-sdb8000-test = "\
	strace \
	i2c-tools \
	loopback-test \
	phytool \
"
