#!/bin/bash
set -eo pipefail

# cd to parent dir of current script
cd "$(dirname "${BASH_SOURCE[0]}")"

old() {
    docker pull jenkins/jenkins:alpine

    docker rm jenksi
    sudo mkdir -p ./jenkins_home/casc_configs
    sudo cp ./jenkins.yaml ./jenkins_home/casc_configs/jenkins.yaml

    docker run -p 8080:8080 -p 50000:50000 -u "$(id -u root)":"$(id -g "$USER")" --name jenksi \
        -v "$PWD/jenkins_home:/var/jenkins_home" \
        -it jenkins/jenkins:alpine

        # -v "$PWD/data:/var/ocr4all/data" \
        # -v "$PWD/models:/var/ocr4all/models/custom" \
}

# docker-compose down || true
# docker volume rm jenksi_jenkins_data
cp ./git-key.pub ./git-keys/id_rsa.pub # copy public key for git
docker-compose up --build
