# Data Respons build system
## Dependencies
- Docker

## How To Use
External recipe sources are included in the project as git submodules.
These modules need to be initialized on first use:

```
git submodule update --init
```

Prepare docker build container running as current user

```
build-tools/make-oe-build.sh
```

Enter container and optionally use project shared downloads and sstate directories.  The -k flag will virtual mount current users  ~/.ssh dir inside the container.

```
build-tools/run-oe-build.sh \
        -c ./ \
        -w ./ \
        -s /home/user/oe/sstate-cache \
        -d /home/user/oe/downloads \
        -k
```

Load yocto build environment. Start ssh-agent if ssh keys will be needed for downloads.
 
```
source ./env
eval $(ssh-agent)
ssh-add

```

Start build of images.

```
bitbake sdb8000-image
```
