# Copyright (C) DATA RESPONS
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-dr.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "lzop-native bc-native elfutils-native"

BRANCH ?= "dr-linux-6.12.y"
SRC_URI = "git://git@github.com/data-respons-solutions/dr-kernel-mirror.git;protocol=https;branch=${BRANCH}"
SRC_URI += "file://defconfig"
SRCREV ?= "5b527005644af9ac5d30fc63a3a840745770abc8"
LINUX_VERSION_EXTENSION = "-1.5"
LINUX_VERSION = "6.12.10"

COMPATIBLE_MACHINE = "sdb8000"
