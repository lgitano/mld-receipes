SUMMARY = "Poetter Theme for VDR plugin graphtftng."
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=9f867da7a73fad2715291348e80d0763"

SRC_URI = "git://github.com/lgitano/vdr-tftng-poetter;protocol=https;branch=main"
SRCREV = "40583b6e4a060e68023f45f26effaf21f139d0c4"

S = "${WORKDIR}/git"

FILES:${PN} = " \
	${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-poetter/* \
	${sysconfdir}/vdr/plugins/graphtftng/* \ 
	"
	
DEPENDS += "vdr-tftng-mango"

do_install() {
        install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/themes
	install -d ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-poetter
	tar xvfz ${S}/channellogos.tar.gz
	rm ${S}/channellogos.tar.gz
	cp -r ${S}/* ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-poetter/
	ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-poetter/ ${D}${sysconfdir}/vdr/plugins/graphtftng/themes/poetter
}
