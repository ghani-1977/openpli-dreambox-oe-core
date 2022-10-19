SUMMARY = "WiFi devices for Realtek 8812AU/8821AU chipsets."
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
        rt8812au \
"

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
