#!/bin/bash

echo -e "\033[1;44;37m ETHEREAL \033[1;2;47;30m PHP VIRTUAL OPERATING SERVER \033[0m\r\n"

source "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/sbin/_core"

lndir opt /opt
lndir mnt /mnt
lndir root /home
lndir bin /bin
lndir lib /lib
lndir proc /proc
lndir dev /dev
lndir tmp "$PREFIX/tmp"
lndir var "$PREFIX/var"

