#!/bin/bash
set -eo pipefail

# cd to parent dir of current script
cd "$(dirname "${BASH_SOURCE[0]}")"

docker-compose down --rmi all -v || true

# docker volume rm jenksi_jenkins_data

cache=
for arg in "$@"; do
    case $arg in
        -c|--cache)
            cache=1
            ;;
    esac
done

args=()
if [[ ! $cache ]]; then
    args+=(--no-cache)
fi
docker-compose build "${args[@]}"
