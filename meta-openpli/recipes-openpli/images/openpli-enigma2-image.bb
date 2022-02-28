require openpli-image.bb

KERNEL_WIFI_DRIVERS = " \
	firmware-carl9170 \
	firmware-htc7010 \
	firmware-htc9271 \
	firmware-rt2870 \
	firmware-rt73 \
	firmware-rtl8712u \
	firmware-zd1211 \
	\
	kernel-module-ath9k-htc \
	kernel-module-carl9170 \
	kernel-module-r8712u \
	kernel-module-rt2500usb \
	kernel-module-rt2800usb \
	kernel-module-rt73usb \
	kernel-module-rtl8187 \
	kernel-module-zd1211rw \
	"

EXTERNAL_WIFI_DRIVERS = " \
	firmware-rtl8192eu \
	firmware-rtl8188eu \
	\
	rtl8188eu \
	rtl8192eu \
	rt3573 \
	rt5572 \
	rtl8723a \
	rtl8723bs \
	rtl8814au \
	rtl8822bu \
	rt8812au \
	mt7610u \
	mt7601u \
	"

ENIGMA2_PLUGINS = " \
	enigma2-plugin-extensions-audiosync \
	enigma2-plugin-extensions-autobackup \
	enigma2-plugin-extensions-bitrate \
	enigma2-plugin-extensions-cdinfo \
	enigma2-plugin-extensions-cutlisteditor \
	enigma2-plugin-extensions-dvdplayer \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-filecommander \
	enigma2-plugin-extensions-foreca \
	enigma2-plugin-extensions-graphmultiepg \
	enigma2-plugin-extensions-mediaplayer \
	enigma2-plugin-extensions-mediascanner \
	enigma2-plugin-extensions-moviecut \
	enigma2-plugin-extensions-netcaster \
	enigma2-plugin-extensions-openwebif \
	enigma2-plugin-extensions-pictureplayer \
	enigma2-plugin-extensions-internetspeedtest \
	enigma2-plugin-extensions-systemtools \
	enigma2-plugin-extensions-tmbd \
	enigma2-plugin-extensions-youtube \
	\
	enigma2-plugin-softcams-ncam \
	\
	enigma2-plugin-systemplugins-cablescan \
	enigma2-plugin-systemplugins-commoninterfaceassignment \
	enigma2-plugin-systemplugins-fastscan \
	enigma2-plugin-systemplugins-hdmicec \
	enigma2-plugin-systemplugins-hotplug \
	enigma2-plugin-systemplugins-networkbrowser \
	enigma2-plugin-systemplugins-osd3dsetup \
	enigma2-plugin-systemplugins-osdpositionsetup \
	enigma2-plugin-systemplugins-positionersetup \
	enigma2-plugin-systemplugins-satfinder \
	enigma2-plugin-systemplugins-softwaremanager \
	enigma2-plugin-systemplugins-videoenhancement \
	enigma2-plugin-systemplugins-videomode \
	enigma2-plugin-systemplugins-videotune \
	enigma2-plugin-systemplugins-wirelesslan \
	"

DEPENDS += " \
	enigma2 \
	package-index \
	"

IMAGE_INSTALL += " \
	aio-grab \
	cdtextinfo \
	enigma2 \
	libavahi-client \
	settings-autorestore \
	tuxbox-common \
	wget \
	${ENIGMA2_PLUGINS} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "dm500hd dm500hdv2 dm800se dm800sev2 dm520 dm820 dm7020hd dm7080 dm8000 dm900 dm920", "${KERNEL_WIFI_DRIVERS}" , "", d)} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "dm500hd dm500hdv2 dm800se dm800sev2 dm520 dm820 dm7020hd dm7080 dm8000 dm900 dm920", "${EXTERNAL_WIFI_DRIVERS}" , "", d)} \
	"

export IMAGE_BASENAME = "openpli-enigma2"
