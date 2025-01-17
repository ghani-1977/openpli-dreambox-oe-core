SUMMARY = "The icalendar package is a parser/generator of iCalendar files for use with Python."
HOMEPAGE = "http://icalendar.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=1b2957cd26c589d0defcb357be630e80"

DEPENDS = "python3-pytz python3-dateutil"
RDEPENDS:${PN} = "python3-pytz python3-dateutil"

SRC_URI = "https://files.pythonhosted.org/packages/6c/23/187a28257fe26848d07af225cef86abe3712561bd8af93cbd3a64d6eb6ea/icalendar-${PV}.tar.gz"

SRC_URI[md5sum] = "801039f92de296253efafdfb27f85880"
SRC_URI[sha256sum] = "7a298bb864526589d0de81f4b736eeb6ff9e539fefb405f7977aa5c1e201ca00"

S = "${WORKDIR}/icalendar-${PV}"

inherit setuptools3

include ${PYTHON_PN}-package-split.inc
