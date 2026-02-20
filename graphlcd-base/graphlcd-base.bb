SUMMARY = "This is the base package of the GraphLCD project."
DESCRIPTION = "It contains GraphLCD driver libraries: libglcddrivers, libglcdgraphics, Tools (crtfont, convpic, showpic, showtext) + Media files (pictures and splash screens in GLCD format, fonts)"
HOMEPAGE = "https://projects.vdr-developer.org/projects/graphlcd-base"
AUTHOR = "Andreas Regel (andreas.regel AT powarman.de)"
LICENSE = "GPL-2.0-only"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=6b0391b46b6cf6be3df64edb1a174e41"

PR = "git"

SRC_URI = "git://github.com/M-Reimer/graphlcd-base;branch=master;protocol=https"
SRCREV = "4a32dc44527f4f9cde87b6686a540afe44ea8704"  

SRC_URI += " \
	 file://00_Make.config.patch \
	 file://01_tools-includes.patch \
	 file://02_glcdskin-includes.patch \
	 "

S = "${WORKDIR}/git"

DEPENDS = "freetype imagemagick fontconfig"

EXTRA_OEMAKE = " \
		INCLUDES+=-I${STAGING_INCDIR}/freetype2/ \
		INCLUDES+=-I${STAGING_INCDIR}/ImageMagick-7/ \
		"
inherit pkgconfig

do_install() {
        oe_runmake DESTDIR=${D} install
}
