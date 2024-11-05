# Copyright (C) DATA RESPONS
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-dr.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "lzop-native bc-native elfutils-native coreutils-native"

BRANCH ?= "dr-linux-6.11.y"
SRC_URI = "git://git@github.com/data-respons-solutions/dr-kernel-mirror.git;protocol=https;branch=${BRANCH}"
SRC_URI += "file://defconfig"
SRCREV ?= "73ccbbc2b96543dca8a1fe626c35ebf4b6ad7800"
LINUX_VERSION_EXTENSION = "-1.2"
LINUX_VERSION = "6.11.6"

COMPATIBLE_MACHINE = "sdb8000"
