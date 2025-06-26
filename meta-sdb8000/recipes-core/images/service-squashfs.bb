DESCRIPTION = "Service squashfs image for usb boot"

require recipes-core/images/akkodis-image.bb

FEATURE_PACKAGES_service-apps = "\
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-browser \
	packagegroup-sdb8000-service \
	packagegroup-sdb8000-service-usb \
"

IMAGE_FSTYPES = "squashfs"
EXTRA_IMAGECMD = "-b 4K"

IMAGE_FEATURES += "service-apps"
