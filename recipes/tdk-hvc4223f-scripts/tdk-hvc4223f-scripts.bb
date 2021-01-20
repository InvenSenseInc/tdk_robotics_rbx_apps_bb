DESCRIPTION = "TDK Micronas Motor controller Scripts"
SECTION = "Motor Controller scripts"

# Licensing
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

# Sources declaration
SRC_URI = "git://github.com/InvenSenseInc/tdk_robotics_rbx_apps.git;protocol=https;branch=develop"
SRC_URI[md5sum] = "4bccc33cf6f1435e378611a013f01dbe"
SRC_URI[sha256sum] = "1221a54142f1e7c17f81bdaeca9ba162627133f13cba717bc5dd403825b5f603"

# Build options
S = "${WORKDIR}/git/poky/meta-tdk-apps/recipes/tdk-hvc4223f-scripts/files"

# Package versioning
SRCREV = "${AUTOREV}"
PV = "1.0"
PR = "r0"
PV_append = "+git${SRCPV}"

# Package declaration
FILES_${PN} = "${datadir}/tdk/motor_controller/"

do_install() {
    # create the /usr/share/tdk/motor_controller folder in the rootfs with default permissions
    install -d ${D}${datadir}/tdk/motor_controller

    # install script files into /usr/share/tdk/motor_controller folder with default permissions
    install -m 644 ${S}/commands/CMD1_All_off.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD1_Both_on.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD2_set_hold.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD3_set_128mA.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD4_get_speed.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD5_get_motor_current.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD6_get_revolutions.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD6_reset_revolutions.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD8_get_motor_diagnostics.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD9_reset_errros.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD9_set_baudrate_115200_to_9600.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/CMD9_set_baudrate_9600_to_115200.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/commands/crc8-serial-test-rb3_v1.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/demos/drive_square.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/demos/rotate.py ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/Modifications_on_MezzA_board.txt ${D}${datadir}/tdk/motor_controller
    install -m 644 ${S}/HVC4223F_UART_IF.xlsx ${D}${datadir}/tdk/motor_controller
}
