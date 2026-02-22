SUMMARY = "This is the WiringPi Library."
DESCRIPTION = "Welcome to the WiringPi Library, the highly performant GPIO access library for Raspberry Pi boards."
HOMEPAGE = "https://github.com/WiringPi/WiringPi"
AUTHOR = ""
LICENSE = "LGPL-3.0-only"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=6b0391b46b6cf6be3df64edb1a174e41"

TARGET_CC_ARCH += "${LDFLAGS}"
INSANE_SKIP:${PN} += "ldflags"

#PACKAGE_ARCH = "${TUNE_PKGARCH}_extra"

PR = "git"

SRC_URI = "git://github.com/WiringPi/WiringPi;branch=master;protocol=https"
SRCREV = "99f2780c1fa63194802bfac991ff94a301c9cb60"  

SRC_URI += " \
	file://00_dependencies.patch \
	 "
S = "${WORKDIR}/git"

DEPENDS = "libgcrypt"

do_compile() {
	oe_runmake -C ${S}/wiringPi
	oe_runmake -C ${S}/devLib
	oe_runmake -C ${S}/gpio
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/gpio/gpio ${D}${bindir}
	install -d ${D}${libdir}
	install -m 0755 ${S}/wiringPi/libwiringPi.so.3.18 ${D}${libdir}
	ln -s -r ${D}${libdir}/libwiringPi.so.3.18 ${D}${libdir}/libwiringPi.so.3
	ln -s -r ${D}${libdir}/libwiringPi.so.3.18 ${D}${libdir}/libwiringPi.so
	install -m 0755 ${S}/devLib/libwiringPiDev.so.3.18 ${D}${libdir}
	ln -s -r ${D}${libdir}/libwiringPiDev.so.3.18 ${D}${libdir}/libwiringPiDev.so.3
	ln -s -r ${D}${libdir}/libwiringPiDev.so.3.18 ${D}${libdir}/libwiringPiDev.so
	install -d ${D}${includedir}/wiringpi/
	install -m 0644 ${S}/wiringPi/*.h ${D}${includedir}/wiringpi/
}

FILES:${PN} += " \
	${libdir}/libwiringPi.so.* \
	${libdir}/libwiringPiDev.so.* \
	${includedir}/wiringpi/* \
	${bindir}/gpio \
        "
