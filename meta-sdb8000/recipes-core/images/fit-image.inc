LICENSE = "MIT"

# We need the 'mkimage' tool from the u-boot tools and a device tree compiler
# to do our job here
DEPENDS += "virtual/kernel u-boot-tools-native coreutils-native dtc-native"
do_compile[depends] += "virtual/kernel:do_deploy"

FIT_IMAGE_CHECKSUM_ALGO ?= "sha256"

inherit deploy

FIT_EXTRA ??= ""
FIT_ITS_NAME ??= "fit-image-${MACHINE}${FIT_EXTRA}-${DATETIME}.its"
FIT_ITS_NAME[vardepsexclude] = "DATETIME"
FIT_NAME ??= "fit-image-${MACHINE}${FIT_EXTRA}-${DATETIME}.bin"
FIT_NAME[vardepsexclude] = "DATETIME"
FIT_LINK_NAME ??= "fit-image-${MACHINE}${FIT_EXTRA}.bin"
FIT_ITS_LINK_NAME ??= "fit-image-${MACHINE}${FIT_EXTRA}.its"

# Create the FIT from the kernel, initramfs and the devicetree binaries.
do_compile() {
	fitimage_create ${B}/boot_fit_image.its

	# Compress kernel
	cp ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin ${B}/linux.bin
	[ -f ${B}/linux.bin.gz ] && rm ${B}/linux.bin.gz
	gzip -9 ${B}/linux.bin

	uboot-mkimage -f ${B}/boot_fit_image.its ${B}/fit-image.bin
}

do_install() {
	install -d ${D}/boot
	install -m 0644 ${B}/fit-image.bin ${D}/boot/${FIT_NAME}
	ln -s ${FIT_NAME} ${D}/boot/fitImage
}

do_deploy() {
	install -d ${DEPLOYDIR}
	install -m 0644 ${B}/fit-image.bin ${DEPLOYDIR}/${FIT_NAME}
	install -m 0644 ${B}/boot_fit_image.its ${DEPLOYDIR}/${FIT_ITS_NAME}
	ln -s ${FIT_NAME} ${DEPLOYDIR}/${FIT_LINK_NAME}
	ln -s ${FIT_ITS_NAME} ${DEPLOYDIR}/${FIT_ITS_LINK_NAME}
}
addtask deploy after do_compile before do_build
do_deploy[cleandirs] = "${DEPLOYDIR}"

FILES:${PN} = "/boot/*"

PACKAGE_ARCH = "${MACHINE_ARCH}"
