#!/bin/bash
set -eo pipefail

repos=(
    "build-env"
    "jenkins-shared"
    "main"
)

for repo in "${repos[@]}"; do
    rm -rf "./$repo/.git"
    rm -rf "./git-repos/$repo"
done
