# Weston should use drm backend
DEFAULTBACKEND = "drm"

RDEPENDS:${PN} += "nvram-touch-calibration"

do_install:prepend() {
	# Enable libinput touchscreen calibration
	sed -i 's/^#\[libinput\].*/[libinput]/g' ${WORKDIR}/weston.ini
	sed -i '/^\[libinput\]/a calibration_helper=/usr/bin/nvram-calibration-helper' ${WORKDIR}/weston.ini

	# Use maliit virtual keyboard
	sed -e 's/^#\[input-method\].*/[input-method]/g' \
		-e '/^\[input-method\]/a path=${bindir}/maliit-keyboard' \
		-i ${WORKDIR}/weston.ini
}
