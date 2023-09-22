# Copyright (C) DATA RESPONS
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-dr.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "lzop-native bc-native elfutils-native"

BRANCH ?= "sdb8000-linux-6.5.4"
SRC_URI = "git://git@github.com/data-respons-solutions/dr-kernel-mirror.git;protocol=https;branch=${BRANCH}"
SRC_URI += "file://defconfig"
SRCREV ?= "3cc051f54e92a6691636610f62e985f5ba686898"
LOCALVERSION = "-0.0"
LINUX_VERSION = "6.5.4"

DEFAULT_PREFERENCE = "1"

COMPATIBLE_MACHINE = "sdb8000"
