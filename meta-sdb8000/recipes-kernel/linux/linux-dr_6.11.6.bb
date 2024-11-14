# Copyright (C) DATA RESPONS
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-dr.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "lzop-native bc-native elfutils-native coreutils-native"

BRANCH ?= "dr-linux-6.11.y"
SRC_URI = "git://git@github.com/data-respons-solutions/dr-kernel-mirror.git;protocol=https;branch=${BRANCH}"
SRC_URI += "file://defconfig"
SRCREV ?= "f7a63f06350a41aa3d604beb724615c7b8a39101"
LINUX_VERSION_EXTENSION = "-1.3"
LINUX_VERSION = "6.11.6"

COMPATIBLE_MACHINE = "sdb8000"
