inherit autotools pkgconfig
DESCRIPTION = "TDK Thermistor Application"
SECTION = "firmware"

# Licensing
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

# Sources declaration
SRC_URI = "git://github.com/InvenSenseInc/tdk_robotics_rbx_apps.git;protocol=https;branch=develop"
SRC_URI[md5sum] = "4bccc33cf6f1435e378611a013f01dbe"
SRC_URI[sha256sum] = "1221a54142f1e7c17f81bdaeca9ba162627133f13cba717bc5dd403825b5f603"

# Build options
S = "${WORKDIR}/git/poky/meta-tdk-apps/recipes/tdk-thermistor-app/files"
DEPENDS = " \
    libcutils \
    libutils \
    common-headers \
    glib-2.0 \
"
#DEPENDS += "liblog"
LDFLAGS += "-lm"

# Package versioning
SRCREV = "${AUTOREV}"
PV = "1.0"
PR = "r0"
PV_append = "+git${SRCPV}"

# Package declaration
FILES_${PN} = "${prefix}/local/bin/tdk-thermistor-app"

do_install() {
    # install tdk-thermistor-app application into /usr/local/bin folder with default permissions
    install -m 755 ${WORKDIR}/build/tdk-thermistor-app -D ${D}${prefix}/local/bin/tdk-thermistor-app
}
