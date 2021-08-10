RDEPENDS_${PN} += "nvram-touch-calibration"

do_install_prepend() {
	# Enable libinput touchscreen calibration
	sed -i 's/^#\[libinput\].*/[libinput]/g' ${WORKDIR}/weston.ini
	sed -i '/^\[libinput\]/a calibration_helper=/usr/bin/nvram-calibration-helper' ${WORKDIR}/weston.ini
}
