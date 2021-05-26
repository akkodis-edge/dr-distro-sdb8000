DESCRIPTION = "Reference initramfs"

require recipes-bsp/images/datarespons-image.bb

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

FEATURE_PACKAGES_sdb8000-apps = "\
	packagegroup-sdb8000-base \
"

IMAGE_FEATURES += "sdb8000-apps"
