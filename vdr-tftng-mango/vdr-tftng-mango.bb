SUMMARY = "Anthraize Theme for VDR plugin graphtftng."
AUTHOR = "Andreas Grothe"
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=9f867da7a73fad2715291348e80d0763"

SRC_URI = "git://github.com/lgitano/vdr-tftng-mango;protocol=https;branch=main"
SRCREV = "4aabfbe2d4642143c9b2196141a599eeb52a597d"

S = "${WORKDIR}/git"

FILES:${PN} = " \
	${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-mango/* \
	${sysconfdir}/vdr/plugins/graphtftng \
	${sysconfdir}/vdr/plugins/graphtftng/* \ 
	"

do_install() {
	install -d ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-mango
	install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/themes
	install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/fonts
	cp -r ${S}/* ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-mango/
        ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-mango/ ${D}${sysconfdir}/vdr/plugins/graphtftng/themes/anthraize-mango
        ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-mango/fonts/graphTFT.ttf ${D}${sysconfdir}/vdr/plugins/graphtftng/fonts/graphTFT.ttf
}
