SUMMARY = "Vehicle system controller driver"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit module

BRANCH ?= "main"
SRCREV ?= "5900ed07826b7b139f0644c2367ef13592df4261"
SRC_URI = "git://git@github.com/data-respons-solutions/kernel-module-vmcu.git;protocol=ssh;branch=${BRANCH}"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "sdb8000"
KERNEL_MODULE_AUTOLOAD += "vmcu"

RPROVIDES:${PN} += "kernel-module-vmcu"
