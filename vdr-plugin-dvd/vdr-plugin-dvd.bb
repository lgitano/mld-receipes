SUMMARY = "This is the DVD plugin for the Video Disk Recorder (VDR)."
DESCRIPTION = "This is the DVD plugin for the Video Disk Recorder (VDR)."
AUTHOR = "Andreas Schultz"
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://github.com/vdr-projects/vdr-plugin-dvd;branch=master;protocol=https"
SRCREV = "a83a0ccc4b05711f544420b9b62fc5664e216d44"

S = "${WORKDIR}/git"

inherit vdr-plugin

DEPENDS += "libdvdcss libdvdnav liba52"

do_install() {
	oe_runmake DESTDIR=${D} install
}
