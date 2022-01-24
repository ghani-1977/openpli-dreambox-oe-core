SUMMARY = "satip client using vtuner"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

SRC_URI = " \
    git://github.com/oe-alliance/satip-client.git;protocol=https;branch=mis \
    file://satipclient.sh \
"
#SRC_URI += "file://auto-detect-and-avoi-ioct-conflicts.patch"

S = "${WORKDIR}/git"

inherit gitpkgv autotools update-rc.d

INITSCRIPT_NAME = "satipclient"
INITSCRIPT_PARAMS = "defaults"

do_install:append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/satipclient.sh ${D}${sysconfdir}/init.d/satipclient
}

EXTRA_OECONF = " \
    --with-boxtype=${MACHINE} \
    "