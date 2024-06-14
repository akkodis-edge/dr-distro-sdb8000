# Copyright 2013-2016 (C) Freescale Semiconductor
# Copyright 2017-2021 (C) NXP
# Copyright 2018 (C) O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
#
# SPDX-License-Identifier: MIT
#

SUMMARY = "Linux Kernel provided and supported by NXP"
DESCRIPTION = "Linux Kernel provided and supported by NXP with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require linux-imx.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "sdb8000-lf-5.10.y"
LINUX_VERSION_EXTENSION = "-2.0.2"
SRCREV = "7f54f203a00b0f6286011cbd02c057811a84de8b"

# PV is defined in the base in linux-imx.inc file and uses the LINUX_VERSION definition
# required by kernel-yocto.bbclass.
#
# LINUX_VERSION define should match to the kernel version referenced by SRC_URI and
# should be updated once patchlevel is merged.
LINUX_VERSION = "5.10.9"

DEFAULT_PREFERENCE = "1"

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

SRC_URI += "git://github.com/data-respons-solutions/dr-kernel-mirror.git;protocol=https;branch=${SRCBRANCH} \
           file://defconfig \
           file://0001-sdb8000-enable-fec.patch \
           "
