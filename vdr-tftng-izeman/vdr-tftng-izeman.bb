SUMMARY = "Izeman Theme for VDR plugin graphtftng."
PV = "git"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=9f867da7a73fad2715291348e80d0763"

SRC_URI = "git://github.com/lgitano/vdr-tftng-izeman;protocol=https;branch=main"
SRCREV = "06bf27f46968f7705ade20e09cb127e6200e216b"

S = "${WORKDIR}/git"

FILES:${PN} = " \
	${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-izeman/* \
	${sysconfdir}/vdr/plugins/graphtftng/* \ 
	"

do_install() {
        install -d ${D}${sysconfdir}/vdr/plugins/graphtftng/themes
	install -d ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-izeman
	tar xvfz ${S}/logos.tar.gz
	rm ${S}/logos.tar.gz
	cp -r ${S}/* ${D}${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-izeman/
	ln -sf ${datadir}/vdr/plugins/graphtftng/themes/vdr-tftng-izeman ${D}${sysconfdir}/vdr/plugins/graphtftng/themes/izeman
}
