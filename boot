#!/bin/bash

set -e

echo -e "\033[1;44;37m ETHEREAL \033[1;2;47;30m PHP VIRTUAL OPERATING SERVER \033[0m"

echo | sleep 1

ROOT="$(cd "$(dirname ${BASH_SOURCE[0]})" && echo $(pwd))"

SHELL="$(command -v bash)"

HOME="$ROOT/home"

TMPDIR="$ROOT/tmp"

PREFIX="$ROOT/usr"

SVDIR="$PREFIX/var/service"

LOGDIR="$PRFIX/var/log"
_="$PREFIX/bin/env"

symlink() {
	local path=${1:?'required argument (path)'}

	local target=${2:?'required argument (target)'}

	sleep 1

	if ! [[ -d "$target" ]]; then
		echo -e "=> \033[0;31mCould not link with unexisted target directory '$target'.\033[0m"
		return 0
	fi

	if [[ -d "$ROOT/$path" ]]; then
		echo -e "=> \033[0;33m'$ROOT/$path' was already existed.\033[0m"
		return 0
	fi

	echo -e "=> \033[0;32m'$ROOT/$path' was link with '$target' directory.\033[0m"

	ln -s "$target" "$ROOT/$path" 	
}

symlink opt /opt
symlink mnt /mnt
symlink root /home

PATH="$ROOT/bin:$PREFIX/bin:$PREFIX/sbin:$PREFIX/local/bin"

