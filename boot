#!/bin/bash

set +e

echo -e "\033[1;44;37m ETHEREAL \033[1;2;47;30m PHP VIRTUAL OPERATING SERVER \033[0m\r\n"

ROOT="$(cd "$(dirname ${BASH_SOURCE[0]})" && echo $(pwd))"

SHELL="$(command -v bash)"

HOME="$ROOT/home"

TMPDIR="$ROOT/tmp"

PREFIX="$ROOT/usr"

SVDIR="$PREFIX/var/service"

LOGDIR="$PRFIX/var/log"

_="$PREFIX/bin/env"

center() {
	local buffer=${1:?'required argument (buffer_skze)'}	
	local input="${2:?''}"
	local len=$(((buffer-${#input})/2)) 
	[ $len -lt 0 ] && len=0
	printf "%${len}s%s%${len}s" '' $input ''
	return 0
}

delay() {
	local ms=${1:-0}
	if [[ $ms -lt 1000 ]]; then
		sleep 0.$ms
	else
		sleep $((ms/1000))
	fi
}

symlink() {
	local path=${1:?'required argument (path)'}
	local target=${2:?'required argument (target)'}
	local rejected='\033[%dm[%s] %s %s\033[0m\r\n'
	local resolved='\033[%dm[%s] %s -> %s\033[0m\r\n'

	delay 260

	if [[ ! -d "$target" ]]; then
		printf "$rejected" 31 "$(center 6 FAIL)" $target 'Unexisted target directory'
		return 0
	fi

	if [[ -d "$ROOT/$path" ]]; then
		printf "$rejected" 33 "$(center 6  FAIL)" $path 'Already existed'
		return 0
	fi

	printf "$resolved" 32 "$(center 6 LINK)" $path $target 

	ln -s "$target" "$ROOT/$path" 	
}

symlink opt /opt
symlink mnt /mnt
symlink root /home
symlink bin /bin
symlink lib /lib
symlink proc /proc
symlink dev /dev
symlink tmp "$PREFIX/tmp"
symlink var "$PREFIX/var"

PATH="$ROOT/bin:$ROOT/sbin:$PREFIX/bin:$PREFIX/local/bin"

echo $PATH
