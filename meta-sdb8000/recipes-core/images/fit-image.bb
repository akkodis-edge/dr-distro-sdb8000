require recipes-core/images/fit-image.inc

fitimage_create() {
	cat << EOF > ${1}
/dts-v1/;

/ {
    description = "${DISTRO_NAME}-${MACHINE}-${DR_CM_COMMIT}";
    #address-cells = <1>;

    images {
        kernel-1 {
            description = "Linux kernel";
            data = /incbin/("${B}/linux.bin.gz");
            type = "kernel";
            arch = "arm64";
            os = "linux";
            compression = "gzip";
            load = <${UBOOT_LOADADDRESS}>;
            entry = <${UBOOT_ENTRYPOINT}>;
            hash-1 {
                algo = "${FIT_IMAGE_CHECKSUM_ALGO}";
            };
        };
        fdt-sdb8000.dtb {
            description = "Flattened Device Tree blob";
            data = /incbin/("${DEPLOY_DIR_IMAGE}/sdb8000.dtb");
            type = "flat_dt";
            arch = "arm64";
            compression = "none";
            load = <${UBOOT_DTB_LOADADDRESS}>;
            hash-1 {
                algo = "${FIT_IMAGE_CHECKSUM_ALGO}";
            };
        };
        fdt-vdt8007.dtb {
            description = "Flattened Device Tree blob";
            data = /incbin/("${DEPLOY_DIR_IMAGE}/vdt8007.dtb");
            type = "flat_dt";
            arch = "arm64";
            compression = "none";
            load = <${UBOOT_DTB_LOADADDRESS}>;
            hash-1 {
                algo = "${FIT_IMAGE_CHECKSUM_ALGO}";
            };
        };
        fdt-vdt8010.dtb {
            description = "Flattened Device Tree blob";
            data = /incbin/("${DEPLOY_DIR_IMAGE}/vdt8010.dtb");
            type = "flat_dt";
            arch = "arm64";
            compression = "none";
            load = <${UBOOT_DTB_LOADADDRESS}>;
            hash-1 {
                algo = "${FIT_IMAGE_CHECKSUM_ALGO}";
            };
        };
	};
    configurations {
        default = "conf-sdb8000.dtb";
        conf-sdb8000.dtb {
            description = "Normal boot";
            compatible = "";
            kernel = "kernel-1";
            fdt = "fdt-sdb8000.dtb";
        };
        conf-vdt8007.dtb {
            description = "Normal boot";
            compatible = "";
            kernel = "kernel-1";
            fdt = "fdt-vdt8007.dtb";
        };
        conf-vdt8010.dtb {
            description = "Normal boot";
            compatible = "";
            kernel = "kernel-1";
            fdt = "fdt-vdt8010.dtb";
        };
	};
};
EOF
}

COMPATIBLE_MACHINE = "sdb8000"
