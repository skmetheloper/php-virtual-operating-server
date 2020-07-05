#!/bin/bash

export ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

source "$ROOT/usr/include/_core"

export PATH="$PATH:$ROOT/bin:$ROOT/sbin:$PREFIX/bin:$PREFIX/local/bin"

echo -e "\033[0;1;47;30m ETHEREAL \033[0;44;37m PHP VIRTUAL OPERATING SERVER \033[0m\r\n"

lndir opt /opt
lndir mnt /mnt
lndir home /root
lndir bin /bin
lndir lib /lib
lndir proc /proc
lndir dev /dev
lndir tmp "$PREFIX/tmp"
lndir var "$PREFIX/var"

