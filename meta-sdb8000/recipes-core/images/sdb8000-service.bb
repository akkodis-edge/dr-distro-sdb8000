DESCRIPTION = "Service image for factory use"

require recipes-core/images/datarespons-image.bb

FEATURE_PACKAGES_sdb8000-apps = "\
	packagegroup-sdb8000-base \
	packagegroup-sdb8000-service \
"

IMAGE_FEATURES += "sdb8000-apps"
IMAGE_INSTALL:append = " kernel-image-fitimage"
