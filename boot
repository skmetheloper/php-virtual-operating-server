#!/bin/bash

ROOT="$(cd "$(dirname ${BASH_SOURCE[0]})" && echo $(pwd))"

SHELL="$(command -v bash)"
HOME="$ROOT/home"
TMPDIR="$ROOT/tmp"
PREFIX="$ROOT/usr"
SVDIR="$ROOT/var/service"
LOGDIR="$ROOT/var/log"
_="$ROOT/bin/env"
PATH="$ROOT/bin:$PATH"

cd && pwd

