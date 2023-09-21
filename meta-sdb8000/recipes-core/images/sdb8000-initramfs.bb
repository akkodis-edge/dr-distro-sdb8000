DESCRIPTION = "Reference initramfs"

require recipes-core/images/datarespons-image.bb

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

FEATURE_PACKAGES_sdb8000-apps = "\
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-test \
	packagegroup-sdb8000-factory \
"

IMAGE_FEATURES += "sdb8000-apps"
