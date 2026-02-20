SUMMARY = "GraphTFT plugin for VDR"
DESCRIPTION = "GraphTFT is a plugin for the Video Disc Recorder and shows information about the current state of VDR on sencodary displays."
AUTHOR = "Jörg Wendel <vdr@jwendel.de>"

PV = "git"
LICENSE = "GPL-2.0-only"

SRCREV = "76a0802a6dd84c9c049a5492152f64761a66844d"
SRC_URI = "git://github.com/vdr-projects/vdr-plugin-graphtftng;protocol=https;branch=master"
SRC_URI[sha256sum] = "27654712d582fd2bea12d730e8d824bc82281617"

SRC_URI += " \
	 file://00_Makefile.patch \
	 file://remote.conf.graphtft-fe \
	 "

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"

inherit vdr-plugin

DEPENDS += "ffmpeg imlib2 libgtop glib-2.0 libexif ttf-bitstream-vera vdr-tftng-mango"


do_install() {
	oe_runmake DESTDIR=${D} install

         install -m 0644 -D ${WORKDIR}/remote.conf.graphtft-fe ${D}${sysconfdir}/vdr/remote.conf.d/graphtft-fe.conf
         install -m 0755 -D ${S}/graphtft-fe/graphtft-fe ${D}${bindir}/graphtft-fe
         install -d ${D}${sysconfdir}/vdr/plugins/graphtftng
	 install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/themes
	 install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/fonts
}
