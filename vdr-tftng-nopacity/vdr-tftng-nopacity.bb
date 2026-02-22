SUMMARY = "nOpacity Theme for VDR plugin graphtftng."
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=9f867da7a73fad2715291348e80d0763"

SRC_URI = "git://github.com/lgitano/vdr-tftng-nopacity;protocol=https;branch=main"
SRCREV = "78df35a1398cd61d5fb8ae814d305fff241a4f99"

S = "${WORKDIR}/git"

FILES:${PN} = " \
	${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-nopacity/* \
	${sysconfdir}/vdr/plugins/graphtftng/* \ 
	"

do_install() {
        install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/themes
	install -d ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-nopacity
	cp -r ${S}/* ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-nopacity/
	ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-nopacity ${D}${sysconfdir}/vdr/plugins/graphtftng/themes/nOpacity
}
