SUMMARY = "WiFi devices for Realtek 88x2CU chipsets."
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
        rt8822cu \
"

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
