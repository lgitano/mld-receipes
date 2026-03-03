SUMMARY = "Mousemate is a "plugin" for the Video Disk Recorder (VDR)."
DESCRIPTION = "This plugin allows using a mouse to control almost each of VDR's functions by mapping remote control keys to mouse actions."
AUTHOR = "Joachim Welker <j.welker@gmx.net>  Peter Pinnau <vdr@unterbrecher.de>"
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://github.com/vdr-projects/vdr-plugin-mousemate;branch=master;protocol=https"
SRCREV = "fc819ac44dfa6c1f45b267523b9a07c1d6eb531e"

S = "${WORKDIR}/git"

inherit vdr-plugin

do_install() {
	oe_runmake DESTDIR=${D} install
}
