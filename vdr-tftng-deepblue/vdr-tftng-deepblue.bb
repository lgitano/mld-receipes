SUMMARY = "DeepBlue Theme for VDR plugin graphtftng."
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=9f867da7a73fad2715291348e80d0763"

SRC_URI = "git://github.com/lgitano/vdr-tftng-deepblue;protocol=https;branch=main"
SRCREV = "fe5d13718243554534c0379630087a38acc93777"

S = "${WORKDIR}/git"

FILES:${PN} = " \
	${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-deepblue/* \
	${sysconfdir}/vdr/plugins/graphtftng \
	${sysconfdir}/vdr/plugins/graphtftng/* \ 
	"

do_install() {
	install -d ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-deepblue
	install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/themes
	install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/fonts
	tar xvfz ${S}/channellogos.tar.gz
	rm ${S}/channellogos.tar.gz
	cp -r ${S}/* ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-deepblue/
        ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-deepblue/ ${D}${sysconfdir}/vdr/plugins/graphtftng/themes/DeepBlue
        ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-deepblue/fonts/graphTFT.ttf ${D}${sysconfdir}/vdr/plugins/graphtftng/fonts/graphTFT.ttf
}
