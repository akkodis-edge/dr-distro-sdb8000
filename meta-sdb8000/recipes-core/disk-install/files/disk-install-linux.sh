#!/bin/bash

die() {
	echo $1
	exit 1
}

if [ "$#" -lt "1" ]; then
	die "Usage: $0 IMAGE"
fi
IMAGE="$1"
DEVICE="/dev/mmcblk2"
LOG="/tmp/disk-install-linux.yaml"

read -r -d '' config <<- EOM
partitions:
   - label: rootfs1
     fs: ext4
     size: 3000
   - label: rootfs2
     fs: ext4
     size: 3000
   - label: data
     fs: ext4
     size: 9000
images:
   - name: image
     type: tar.bz2
     target: label:rootfs1
EOM

printf '%s\n' "$config"
if printf '%s\n' "$config" | image-install --force-unmount --wipefs --device "$DEVICE" --log "$LOG" --config - image="${IMAGE}"; then
	## set nvram variables
	NVRAM_SYSTEM_UNLOCK=16440 nvram --sys \
		--set SYS_BOOT_PART rootfs1 \
		--set SYS_BOOT_SWAP rootfs1 \
		--del SYS_BOOT_ATTEMPTS || die "Failed setting nvram variables"
	echo "Success!"
	exit 0
fi

echo "Image installation failed"
exit 1
