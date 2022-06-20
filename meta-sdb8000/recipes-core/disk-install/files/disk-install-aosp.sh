#!/bin/bash

die() {
	echo $1
	exit 1
}

if [ "$#" -lt "1" ]; then
	die "Usage: $0 DIR"
fi

DIR="$1"
DEVICE="/dev/mmcblk2"

read -r -d '' config <<- EOM
images:
   - name: table
     type: raw
     target: device
     reload_partitions: true
   - name: boot
     type: raw
     target: label:boot_a
   - name: dtbo
     type: raw
     target: label:dtbo_a
   - name: vbmeta
     type: raw
     target: label:vbmeta_a
   - name: vendor_boot
     type: raw
     target: label:vendor_boot_a
   - name: super
     type: android-sparse
     target: label:super
EOM

printf '%s\n' "$config"
if printf '%s\n' "$config" | image-install --force-unmount --wipefs --device "$DEVICE" --config - \
	table="${DIR}/partition-table.img" \
	super="${DIR}/super.img" \
	boot="${DIR}/boot.img" \
	dtbo="${DIR}/dtbo-imx8mm.img" \
	vbmeta="${DIR}/vbmeta-imx8mm.img" \
	vendor_boot="${DIR}/vendor_boot.img"; then
		echo "Success!"
		exit 0
fi

echo "Image installation failed"
exit 1

