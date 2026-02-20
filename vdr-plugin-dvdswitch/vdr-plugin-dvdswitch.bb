SUMMARY = "This is a "plugin" for the Video Disk Recorder (VDR)."
DESCRIPTION = "The dvdswitch plugin functions as a kind of a DVD changer. It makes it possible to select images and play them with the DVD plugin."
AUTHOR = "Andreas Schmidt(Darkside) +  Andreas Brachold"
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://github.com/vdr-projects/vdr-plugin-dvdswitch;branch=master;protocol=https"
SRCREV = "dfca6ae8ec8a1f0d3c0fd43847ef14e3d6ac7f5e"

S = "${WORKDIR}/git"

inherit vdr-plugin

DEPENDS += "vdr-plugin-dvd"

do_install() {
	oe_runmake DESTDIR=${D} install
}
