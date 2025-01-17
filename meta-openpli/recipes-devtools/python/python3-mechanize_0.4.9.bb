SUMMARY = "Stateful programmatic web browsing, after Andy Lester's Perl module WWW::Mechanize."
HOMEPAGE = "https://github.com/python-mechanize/mechanize"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=621053d4e9daec9454e15e60fe40214f"

RDEPENDS:${PN} = "python3-core"

SRC_URI = "https://files.pythonhosted.org/packages/33/e6/bb760d200e895a9d1d2b8187d572726249e3c6fe8554388a20911ba30363/mechanize-${PV}.tar.gz"

SRC_URI[md5sum] = "f5d078e07b2a0b2fec73c82dcd275e8c"
SRC_URI[sha256sum] = "69a5edb0962f921e8b10837368c2242d8ad049f0b91ff699ce7f601bfc431521"

S = "${WORKDIR}/mechanize-${PV}"

inherit setuptools3

include ${PYTHON_PN}-package-split.inc
