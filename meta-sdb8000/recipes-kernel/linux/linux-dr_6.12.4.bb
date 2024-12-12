# Copyright (C) DATA RESPONS
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-dr.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "lzop-native bc-native elfutils-native"

BRANCH ?= "dr-linux-6.12.y"
SRC_URI = "git://git@github.com/data-respons-solutions/dr-kernel-mirror.git;protocol=https;branch=${BRANCH}"
SRC_URI += "file://defconfig"
SRCREV ?= "d80d75ebae7fdf05f8693df6be7aef87606e7817"
LINUX_VERSION_EXTENSION = "-1.4"
LINUX_VERSION = "6.12.4"

COMPATIBLE_MACHINE = "sdb8000"
