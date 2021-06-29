FROM jenkins/jenkins:lts-jdk11

# setup git-keys
USER root
COPY --chown=1000:1000 ./git-key /var/jenkins_home/gitkey
# just for debugging
COPY ./git-key /root/.ssh/id_rsa
RUN chmod 0600 /root/.ssh/id_rsa

# setup jenkins
USER jenkins

# copy the list of plugins we want to install
COPY plugins.txt /usr/share/jenkins/plugins.txt
# run the install-plugins script to install the plugins
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/plugins.txt

# disable the setup wizard as we will set up jenkins as code :)
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

# # copy the config-as-code yaml file into the image
# COPY jenkins-casc.yaml /usr/share/jenkins/jenkins-casc.yaml
# tell the jenkins config-as-code plugin where to find the yaml file
ENV CASC_JENKINS_CONFIG /usr/share/jenkins/jenkins-casc.yaml
