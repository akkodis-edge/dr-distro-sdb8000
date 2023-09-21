# Copyright (C) 2012, 2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel-yocto kernel fsl-vivante-kernel-driver-handler

# Set the PV to the correct kernel version to satisfy the kernel version sanity check
PV = "${LINUX_VERSION}${LOCALVERSION}"
S = "${WORKDIR}/git"

do_kernel_localversion() {
	# Add GIT revision to the local version
	head=`git --git-dir=${S}/.git rev-parse --verify --short HEAD 2> /dev/null`
	printf "%s-%s%s" ${LOCALVERSION} +g $head > ${S}/.scmversion
}

addtask kernel_localversion before do_configure after do_patch do_kernel_metadata

SRC_URI = "git://github.com/data-respons-solutions/dr-kernel-mirror.git;protocol=https;branch=${SRCBRANCH} \
	file://defconfig \
"

# Tell to kernel class that we would like to use our defconfig to configure the kernel.
# Otherwise, the --allnoconfig would be used per default which leads to mis-configured
# kernel.
#
# This behavior happens when a defconfig is provided, the kernel-yocto configuration
# uses the filename as a trigger to use a 'allnoconfig' baseline before merging
# the defconfig into the build.
#
# If the defconfig file was created with make_savedefconfig, not all options are
# specified, and should be restored with their defaults, not set to 'n'.
# To properly expand a defconfig like this, we need to specify: KCONFIG_MODE="--alldefconfig"
# in the kernel recipe include.
KCONFIG_MODE="--alldefconfig"

# We need to pass it as param since kernel might support more then one
# machine, with different entry points
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
