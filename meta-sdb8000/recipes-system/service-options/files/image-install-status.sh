#!/bin/sh

case "$1" in
	"start")
		status-led green blink
		;;
	"success")
		status-led green
		;;
	*)
		status-led red
		;;
esac

exit 0