SUMMARY = "General purpose components extending the circuits framework."
HOMEPAGE = "http://packages.python.org/circuits-bricks"
AUTHOR = "Michael N. Lipp <mnl@mnl.de>"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;md5=52d82042b8abd821ed37352d5cc179c3"

RDEPENDS:${PN} = "python3-circuits"

SRC_URI = "https://files.pythonhosted.org/packages/93/bd/a5400ce8f393b921bd471e6816fdea1abb5be3b50adc07dd8fe1810743fe/circuits-bricks-${PV}.tar.gz \
    file://importlib.patch \
"

SRC_URI[md5sum] = "8bcf94ba15fd2340ab6025fa80f3a8e6"
SRC_URI[sha256sum] = "334a1a9439e53557ac2b8b6e6e2151c99059404148e07b4360a8a43be0228b2b"

S = "${WORKDIR}/circuits-bricks-${PV}"

inherit setuptools3_legacy

include ${PYTHON_PN}-package-split.inc
