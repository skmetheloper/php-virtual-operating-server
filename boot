#!/bin/bash

echo -e "\033[1;44;37m ETHEREAL \033[1;2;47;30m PHP VIRTUAL OPERATING SERVER \033[0m\r\n"

source "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/sbin/_core"

symlink opt /opt
symlink mnt /mnt
symlink root /home
symlink bin /bin
symlink lib /lib
symlink proc /proc
symlink dev /dev
symlink tmp "$PREFIX/tmp"
symlink var "$PREFIX/var"
echo $PATH
