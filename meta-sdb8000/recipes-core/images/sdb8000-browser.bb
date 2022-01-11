DESCRIPTION = "Reference image with browser"

require recipes-bsp/images/datarespons-image.bb

FEATURE_PACKAGES_sdb8000-apps = "\
	packagegroup-sdb8000-browser \
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-test \
	packagegroup-sdb8000-factory \
"

IMAGE_FEATURES += "sdb8000-apps"
IMAGE_INSTALL_append += " kernel-image-fitimage"
