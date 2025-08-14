# Weston should use drm backend
DEFAULTBACKEND = "drm"

RDEPENDS:${PN} += "nvram-touch-calibration"

do_install:prepend() {
	# Enable libinput touchscreen calibration
	sed -e 's/^#\[libinput\].*/[libinput]/g' \
		-e '/^\[libinput\]/a calibration_helper=/usr/bin/nvram-calibration-helper' \
		-i ${S}/weston.ini

	# Use maliit virtual keyboard
	sed -e 's/^#\[input-method\].*/[input-method]/g' \
		-e '/^\[input-method\]/a path=${bindir}/maliit-keyboard' \
		-i ${S}/weston.ini
}
