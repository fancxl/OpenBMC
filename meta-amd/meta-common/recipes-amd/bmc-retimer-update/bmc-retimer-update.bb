SUMMARY = "Retimer Update application"
DESCRIPTION = "Used for performing Retimer updates through BMC"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

LICENSE = "CLOSED"

inherit meson pkgconfig systemd

DEPENDS += " \
    i2c-tools \
    phosphor-dbus-interfaces \
    phosphor-logging \
    sdbusplus \
    boost \
    nlohmann-json \
    libaries-retimer \
    "

RDEPENDS_${PN} += "bash"

SRC_URI="file:///home/fan/bmc/bmc-retimer-update;branch=main;protocol=ssh"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

INSANE_SKIP_${PN} += "ldflags"
