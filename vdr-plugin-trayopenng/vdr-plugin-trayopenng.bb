SUMMARY = "This is the DVD plugin for the Video Disk Recorder (VDR)."
DESCRIPTION = "Open and close the CD-Rom tray."
AUTHOR = "Ulrich Eckhardt"
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://github.com/vdr-projects/vdr-plugin-trayopenng;branch=master;protocol=https"
SRCREV = "baabc54d841483ec1a51ed8217d2a6bfb84fe9ee"

#SRC_URI += " \
#	file://01_statusleds.patch \
#	"

S = "${WORKDIR}/git"

inherit vdr-plugin

do_install() {
	oe_runmake DESTDIR=${D} install
}
