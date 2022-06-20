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

read -r -d '' config <<- EOM
partitions:
   - label: rootfs1
     fs: ext4
     size: 1000
   - label: rootfs2
     fs: ext4
     size: 1000
   - label: data
     fs: ext4
     size: 10000
images:
   - name: image
     type: tar.bz2
     target: label:rootfs1
EOM

printf '%s\n' "$config"
if printf '%s\n' "$config" | image-install --force-unmount --wipefs --device "$DEVICE" --config - image="${IMAGE}"; then
	## set nvram variables
	NVRAM_SYSTEM_UNLOCK=16440 nvram --sys set SYS_BOOT_PART rootfs1 || die "Failed setting nvram variable SYS_BOOT_PART"
	NVRAM_SYSTEM_UNLOCK=16440 nvram --sys set SYS_BOOT_SWAP rootfs1 || die "Failed setting nvram variable SYS_BOOT_SWAP"
	NVRAM_SYSTEM_UNLOCK=16440 nvram --sys delete SYS_BOOT_ATTEMPTS || die "Failed deleting nvram variable SYS_BOOT_ATTEMPTS"
	echo "Success!"
	exit 0
fi

echo "Image installation failed"
exit 1

