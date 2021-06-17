#!/bin/sh

die() {
	echo $1
	exit 1
}

if [ "$#" -lt "1" ]; then
	die "Usage: $0 IMAGE"
fi

echo "Image details:"
echo "  name: ${1}"


# Clear and create partitions
blockdev-init /dev/mmcblk2 \
	rootfs1 ext4 1000 \
	rootfs2 ext4 1000 \
	data ext4 10000 \
		|| die "Failed initializing blockdev"


# Install image
mkdir -v /mnt/rootfs1 || die "rootfs1 mountpoint already exists"
mount -v -L rootfs1 /mnt/rootfs1 || die "failed mounting rootfs1"
echo "Extracting rootfs.."
tar -xf ${1} -C /mnt/rootfs1 || die "Failed extracting rootfs"
umount -v /mnt/rootfs1 || die "Failed unmounting rootfs1"
rmdir -v /mnt/rootfs1 || die "Failed removing mountpoint"

## set nvram variables
NVRAM_SYSTEM_UNLOCK=16440 nvram --sys set SYS_BOOT_PART rootfs1 || die "Failed setting nvram variable SYS_BOOT_PART"
NVRAM_SYSTEM_UNLOCK=16440 nvram --sys set SYS_BOOT_SWAP rootfs1 || die "Failed setting nvram variable SYS_BOOT_SWAP"
NVRAM_SYSTEM_UNLOCK=16440 nvram --sys delete SYS_BOOT_ATTEMPTS || die "Failed deleting nvram variable SYS_BOOT_ATTEMPTS"

# Sync filesystem
sync || die "Failed syncing filesystem"

# Image installation successfull
echo "Image installation completed"
exit 0
