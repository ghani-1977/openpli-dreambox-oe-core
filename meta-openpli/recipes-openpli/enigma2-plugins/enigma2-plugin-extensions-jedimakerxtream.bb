DESCRIPTION = "Jedi Maker Xtream (Enigma2 IPTV Bouquet Creator)"
MAINTAINER = "kiddac"
require conf/license/license-gplv2.inc
HOMEPAGE = "https://github.com/kiddac/Jedi_Maker_Xtream"

DEPENDS += "${PYTHON_PN}-backports-lzma"

include ${PYTHON_PN}-package-split.inc
require classes/python3-compileall.inc

inherit gitpkgv allarch

SRCREV="${AUTOREV}"
PV = "6.21+git${SRCPV}"
PKGV = "6.21+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/kiddac/Jedi_Maker_Xtream.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

FILES:${PN} = " ${sysconfdir}/enigma2/jediplaylists/* \
                ${libdir}/enigma2/python/Plugins/Extensions/JediMakerXtream/*"

do_install () {
	install -d ${D}/${sysconfdir}/enigma2/jediplaylists
	install -d ${D}/${libdir}/enigma2/python/Plugins/Extensions/JediMakerXtream
	cp -rf ${S}/JediMakerXtream//etc/enigma2/jediplaylists/* ${D}/${sysconfdir}/enigma2/jediplaylists/
	cp -rf ${S}/JediMakerXtream/usr/lib/enigma2/python/Plugins/Extensions/JediMakerXtream/* ${D}/${libdir}/enigma2/python/Plugins/Extensions/JediMakerXtream/
}

pkg_preinst:${PN} () {
#!/bin/sh
	rm -rf /etc/enigma2/jediplaylists/playlist_all.json > /dev/null 2>&1
	rm -rf /usr/lib/enigma2/python/Plugins/Extensions/JediMakerXtream > /dev/null 2>&1
	rm -rf /etc/enigma2/*jmx*.* > /dev/null 2>&1
	rm -rf /etc/epgimport/*jmx*.* > /dev/null 2>&1
	sed -i '/jmx/d' /etc/enigma2/bouquets.tv
}

pkg_postrm:${PN} () {
#!/bin/sh
	rm -rf /etc/enigma2/jediplaylists/playlist_all.json > /dev/null 2>&1
	rm -rf /usr/lib/enigma2/python/Plugins/Extensions/JediMakerXtream > /dev/null 2>&1
	rm -rf /etc/enigma2/*jmx*.* > /dev/null 2>&1
	rm -rf /etc/epgimport/*jmx*.* > /dev/null 2>&1
	sed -i '/jmx/d' /etc/enigma2/bouquets.tv
	echo "Restart GUI to finish uninstall!"
}

INSANE_SKIP:${PN} += "installed-vs-shipped"
