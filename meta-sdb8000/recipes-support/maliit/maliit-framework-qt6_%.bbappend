# Disable xcb to allow wayland-only operation
EXTRA_OECMAKE:append = " -Denable-xcb=OFF"
