DESCRIPTION = "Reference image"

require recipes-core/images/akkodis-image.bb

FEATURE_PACKAGES_sdb8000-apps = "\
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-core \
	packagegroup-sdb8000-browser \
"

IMAGE_FEATURES += "sdb8000-apps"
IMAGE_INSTALL:append = " fit-image"
