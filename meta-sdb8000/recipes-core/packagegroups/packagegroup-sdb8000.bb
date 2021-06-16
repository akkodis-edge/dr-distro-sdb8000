SUMMARY = "Standard packages for sdb8000"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-test \
"

RDEPENDS_packagegroup-sdb8000-base = "\
	flash-uboot \
	blockdev-init \
	swap-root \
	nvram \
"

RDEPENDS_packagegroup-sdb8000-test = "\
	strace \
	i2c-tools \
	loopback-test \
"
