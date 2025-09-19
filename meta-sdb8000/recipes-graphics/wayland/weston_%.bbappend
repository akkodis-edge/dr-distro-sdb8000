FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://0002-weston-keyboard-disable-preediting.patch \
	file://0003-weston-keyboard-delete_surrounding-text-as-offset.patch \
	file://0004-weston-keyboard-support-multi-byte-utf-8-characters-.patch \
"
