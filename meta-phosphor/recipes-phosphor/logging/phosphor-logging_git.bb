SUMMARY = "Phosphor OpenBMC event and error logging"
DESCRIPTION = "An error and event log daemon application, and \
               supporting tools for OpenBMC."
HOMEPAGE = "https://github.com/openbmc/phosphor-logging"
PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit meson
inherit python3native
inherit obmc-phosphor-dbus-service
inherit phosphor-logging
inherit phosphor-dbus-yaml

DEPENDS += "systemd"
DEPENDS += "${PYTHON_PN}-mako-native"
DEPENDS += "${PYTHON_PN}-pyyaml-native"
DEPENDS += "${PYTHON_PN}-native"
DEPENDS += "${PYTHON_PN}-sdbus++-native"
DEPENDS += "sdbusplus"
DEPENDS += "phosphor-dbus-interfaces"
DEPENDS += "virtual/phosphor-logging-callouts"
DEPENDS += "libcereal"
DEPENDS += "sdeventplus"
DEPENDS += "packagegroup-obmc-yaml-providers"

PACKAGE_BEFORE_PN = "${PN}-test"
FILES_${PN}-test = "${bindir}/*-test"

# Package configuration
LOGGING_PACKAGES = " \
        ${PN}-base \
        phosphor-rsyslog-config \
"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_BEFORE_PN += "${LOGGING_PACKAGES}"
SYSTEMD_PACKAGES = "${LOGGING_PACKAGES}"
DBUS_PACKAGES = "${LOGGING_PACKAGES}"
USERADD_PACKAGES = "${PN}-base"
GROUPADD_PARAM_${PN}-base = "-r phosphor-logging"

FILES_${PN}-base += " \
        ${sysconfdir}/dbus-1 \
        ${bindir}/phosphor-log-manager \
        ${libdir}/libphosphor_logging.so.* \
"
DBUS_SERVICE_${PN}-base += "xyz.openbmc_project.Logging.service"

DBUS_SERVICE_phosphor-rsyslog-config += "xyz.openbmc_project.Syslog.Config.service"
FILES_phosphor-rsyslog-config += " \
        ${bindir}/phosphor-rsyslog-conf \
"

SRC_URI += "https://github.com/openbmc/phosphor-logging"
SRCREV = "0b08776a882357d7e96ee072d14ba0940287ca93"
SRC_URI[sha256sum] = "afb9b30421782441f3812a3fc1d1bb840dd86f6974492b249bb2a3b5dba4fafe"

S = "${WORKDIR}/git"

PACKAGECONFIG ??= ""

PACKAGECONFIG[openpower-pels] = " \
        -Dopenpower-pel-extension=enabled, \
        -Dopenpower-pel-extension=disabled, \
        nlohmann-json cli11 pldm, \
        python3, \
        "

EXTRA_OEMESON = " \
        -Dyamldir=${STAGING_DIR_TARGET}${yaml_dir} \
        -Dcallout_yaml=${STAGING_DIR_NATIVE}${callouts_datadir}/callouts.yaml \
        "
