inherit autotools pkgconfig
DESCRIPTION = "TDK Chirp Application"
SECTION = "firmware"

# Licensing
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

# Sources declaration
SRC_URI = "git://github.com/InvenSenseInc/tdk_robotics_rbx_apps.git;protocol=https;nobranch=1"
# SRCREV = "${AUTOREV}"
SRCREV = "TDK-Robotics-RB5-0.1-test3"
SRC_URI[md5sum] = "4bccc33cf6f1435e378611a013f01dbe"
SRC_URI[sha256sum] = "1221a54142f1e7c17f81bdaeca9ba162627133f13cba717bc5dd403825b5f603"

# Build options
S = "${WORKDIR}/git/tdk-chx01-get-data-app/files"
DEPENDS = " \
    libcutils \
    libutils \
    common-headers \
    glib-2.0 \
"
#DEPENDS += "liblog"
LDFLAGS += "-lm -L${WORKDIR} -L${S} -Wl,-Bstatic -lInvnAlgoRangeFinder -Wl,-Bdynamic -lgcc_s"

# Package versioning
PV = "1.0"
PR = "r0"
PV_append = "+git${SRCPV}"

# Package declaration
FILES_${PN} = " \
    ${prefix}/local/bin/tdk-chx01-get-data-app \
    ${datadir}/tdk/ \
"

do_install() {
    # install tdk-chx01-get-data-app application into /usr/local/bin folder with default permissions
    install -m 755 ${WORKDIR}/build/tdk-chx01-get-data-app -D ${D}${prefix}/local/bin/tdk-chx01-get-data-app

    # create the /usr/share/tdk folder in the rootfs with default permissions
    install -d ${D}${datadir}/tdk

    # install Chirp FW files into /usr/share/tdk folder with default permissions
    install -m 644 ${S}/firmware/ch101_gpr_rxopt_v41b.bin ${D}${datadir}/tdk/
    install -m 644 ${S}/firmware/ch201_gprmt_v10a.bin ${D}${datadir}/tdk/
}
