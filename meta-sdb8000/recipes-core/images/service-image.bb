DESCRIPTION = "Service image for eMMC boot"

require recipes-core/images/datarespons-image.bb

FEATURE_PACKAGES_service-apps = "\
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-browser \
	packagegroup-sdb8000-service \
"

IMAGE_FEATURES += "service-apps"
IMAGE_INSTALL:append = " fit-image"
