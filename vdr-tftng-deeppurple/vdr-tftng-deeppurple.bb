SUMMARY = "DeepPurple Theme for VDR plugin graphtftng."
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=9f867da7a73fad2715291348e80d0763"

SRC_URI = "git://github.com/lgitano/vdr-tftng-deeppurple;protocol=https;branch=main"
SRCREV = "1d9223647628e25fcb455d0b633c8f9dd3fa27f1"

S = "${WORKDIR}/git"

FILES:${PN} = " \
	${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-deeppurple/* \
	${sysconfdir}/vdr/plugins/graphtftng/* \ 
	"

DEPENDS += "vdr-tftng-mango"

do_install() {
        install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/themes
	install -d ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-deeppurple
	tar xvfz ${S}/channellogos.tar.gz
	rm ${S}/channellogos.tar.gz
	cp -r ${S}/* ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-deeppurple/
	ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-deeppurple/ ${D}${sysconfdir}/vdr/plugins/graphtftng/themes/DeepPurple
}
