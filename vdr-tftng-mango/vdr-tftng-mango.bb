SUMMARY = "Anthraize Theme for VDR plugin graphtftng."
AUTHOR = "Andreas Grothe"
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=9f867da7a73fad2715291348e80d0763"

SRC_URI = "git://github.com/lgitano/vdr-tftng-mango;protocol=https;branch=main"
SRCREV = "3e71676a6ff96a5d78f4a37eb02f4e9b9159adda"

S = "${WORKDIR}/git"

FILES:${PN} = " \
	${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-mango/* \
	${sysconfdir}/vdr/plugins/graphtftng \
	${sysconfdir}/vdr/plugins/graphtftng/* \ 
	"

do_install() {
        install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/themes
	install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/fonts
	install -d ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-mango
	cp -r ${S}/* ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-mango/
	ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-mango/ ${D}${sysconfdir}/vdr/plugins/graphtftng/themes/anthraize-mango
        ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-mango/fonts/graphTFT.ttf ${D}${sysconfdir}/vdr/plugins/graphtftng/fonts/graphTFT.ttf
}
