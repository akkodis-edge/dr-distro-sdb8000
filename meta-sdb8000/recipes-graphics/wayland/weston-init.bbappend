# Weston should use drm backend
DEFAULTBACKEND = "drm"

# Pull in seatd-init
RDEPENDS:${PN} = "seatd-init"

RDEPENDS:${PN} += "nvram-touch-calibration"

do_install:prepend() {
	# Enable libinput touchscreen calibration
	sed -i 's/^#\[libinput\].*/[libinput]/g' ${WORKDIR}/weston.ini
	sed -i '/^\[libinput\]/a calibration_helper=/usr/bin/nvram-calibration-helper' ${WORKDIR}/weston.ini
}
