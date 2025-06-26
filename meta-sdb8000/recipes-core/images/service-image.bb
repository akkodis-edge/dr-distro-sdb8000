DESCRIPTION = "Service image for eMMC boot"

require recipes-core/images/akkodis-image.bb

FEATURE_PACKAGES_service-apps = "\
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-browser \
	packagegroup-sdb8000-service \
	packagegroup-sdb8000-service-disk \
"

IMAGE_FEATURES += "service-apps"
IMAGE_INSTALL:append = " fit-image"
