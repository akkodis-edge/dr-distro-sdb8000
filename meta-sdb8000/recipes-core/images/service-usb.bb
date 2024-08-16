DESCRIPTION = "Service image for USB boot"

inherit image dr-image-info

ROOTFS_BOOTSTRAP_INSTALL = ""

IMAGE_INSTALL = " \
	fit-image-service-usb \
"
# What pulls in glibc-locale? Do we need custom IMAGE_FSTYPES?
clean_up_rootfs() {
	rm -rf ${IMAGE_ROOTFS}/{"var","usr","etc/ld.so.cache"}
}
