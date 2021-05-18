DESCRIPTION = "Reference initramfs"

require recipes-bsp/images/datarespons-image.bb

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

FEATURE_PACKAGES_imx-evk-apps = "\
	packagegroup-imx-evk-base \
"

IMAGE_FEATURES += "imx-evk-apps"
