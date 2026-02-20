SUMMARY = "Anthraize Theme for VDR plugin graphtftng."
AUTHOR = "mapovi"
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=9f867da7a73fad2715291348e80d0763"

PACKAGE_ARCH = "${TUNE_PKGARCH}_extra"

SRC_URI = "git://github.com/lgitano/vdr-tftng-pearlhd;protocol=https;branch=main"
SRCREV = "6ef59e72b6e3067cbd26b00c23f1c2c7c0098f69"

S = "${WORKDIR}/git"

FILES:${PN} = " \
	${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-pearlhd/* \
	${sysconfdir}/vdr/plugins/graphtftng \
	${sysconfdir}/vdr/plugins/graphtftng/* \ 
	"

do_install() {
	install -d ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-pearlhd
	install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/themes
	install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/fonts
	cp -r ${S}/* ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-pearlhd/
        ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-pearlhd/ ${D}${sysconfdir}/vdr/plugins/graphtftng/themes/PearlHD
        ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-pearlhd/fonts/VDRSymbolsSans.ttf ${D}${sysconfdir}/vdr/plugins/graphtftng/fonts/VDRSymbolsSans.ttf
}
