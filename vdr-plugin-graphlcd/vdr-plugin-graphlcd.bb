SUMMARY = "GraphLCD plugin for VDR"
DESCRIPTION = "GraphLCD is a plugin for the Video Disc Recorder and shows information about the current state of VDR on displays supported by the GraphLCD driver library."
AUTHOR = "Carsten Siebholz (c.siebholz AT t-online.de>"
 
PV = "git"
LICENSE = "GPL-2.0-only"

SRCREV = "27654712d582fd2bea12d730e8d824bc82281617"
SRC_URI = "git://github.com/vdr-projects/vdr-plugin-graphlcd;protocol=https;branch=master"

SRC_URI += " \
          file://00_Makefile.patch \
	   "

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"

inherit vdr-plugin

DEPENDS += "graphlcd-base"

do_install() {
	oe_runmake DESTDIR=${D} install
	install -d ${D}${sysconfdir}/vdr/plugins/graphlcd
	install -d ${D}${sharedir}/vdr/plugins/graphlcd
	install -d ${D}${sharedir}/vdr/plugins/graphlcd/fonts
	install -d ${D}${sharedir}/vdr/plugins/graphlcd/logos
	install -d ${D}${sharedir}/vdr/plugins/graphlcd/skins
	install -m 0644 ${S}/graphlcd/fonts/* ${D}${sharedir}/vdr/plugins/graphlcd/fonts
	install -m 0644 ${S}/graphlcd/fonts/* ${D}${sharedir}/vdr/plugins/graphlcd/logos
	install -m 0644 ${S}/graphlcd/fonts/* ${D}${sharedir}/vdr/plugins/graphlcd/skins
	install -m 0644 ${S}/graphlcd/channels.alias ${D}${sharedir}/vdr/plugins/graphlcd/
	ln -sf ${sharedir}/vdr/plugins/graphlcd/fonts/ ${D}${sysconfdir}/vdr/plugins/graphlcd/fonts
	ln -sf ${sharedir}/vdr/plugins/graphlcd/logos/ ${D}${sysconfdir}/vdr/plugins/graphlcd/logos
	ln -sf ${sharedir}/vdr/plugins/graphlcd/skins/ ${D}${sysconfdir}/vdr/plugins/graphlcd/skins
	ln -sf ${sharedir}/vdr/plugins/graphlcd/channels.alias ${D}${sysconfdir}/vdr/plugins/graphlcd/channels.alias
}

FILES:${PN} += " \
         ${sharedir}/vdr/plugins/graphlcd \
         ${sharedir}/vdr/plugins/graphlcd/* \
	 ${sysconfdir}/vdr/plugins/graphlcd \
	 ${sysconfdir}/vdr/plugins/graphlcd/* \
	 "
