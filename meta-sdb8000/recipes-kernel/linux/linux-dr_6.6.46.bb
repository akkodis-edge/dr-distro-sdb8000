# Copyright (C) DATA RESPONS
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-dr.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "lzop-native bc-native elfutils-native"

BRANCH ?= "dr-linux-6.6.y"
SRC_URI = "git://git@github.com/data-respons-solutions/dr-kernel-mirror.git;protocol=https;branch=${BRANCH}"
SRC_URI += "file://defconfig"
SRCREV ?= "988ef1a72267d9e2e1e95108ebb8a89938599174"
LINUX_VERSION_EXTENSION = "-1.0"
LINUX_VERSION = "6.6.46"

COMPATIBLE_MACHINE = "sdb8000"
