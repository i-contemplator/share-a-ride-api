# Share-A-Ride: cs445

## Configuration instructions :
* Update Package Index
```
sudo apt update
```
* Install Java Runtime Environment (JRE) Version 11
```
sudo apt install default-jre
```
* Check the version
```
java -version
```
* Install Java Development Kit (JDK) Version
```
sudo apt install default-jdk
```
* Check the version of Java compiler
```
javac -version
```
* Install Maven 
```
sudo apt install maven
```
* Check the version
```
mvn -version
```
* To download Tomcat 9, First create a new group and system user in Ubuntu to run the tomcat server
```
sudo groupadd tomcat
sudo useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat
```
* Download the latest binary Tomcat release from https://tomcat.apache.org/download-90.cgi. Copy the tar.gz file link. First go to /tmp directory.
```
cd /tmp
curl -O https://mirrors.gigenet.com/apache/tomcat/tomcat-9/v9.0.38/bin/apache-tomcat-9.0.38.tar.gz
```
* Make /opt/tomcat directory and extract the downloaded file (in /tmp).
```
sudo mkdir /opt/tomcat
sudo tar xzvf apache-tomcat-9.0.38.tar.gz -C /opt/tomcat --strip-components=1
```
* Move to tomcat installation directory to give the new user executable privileges.
```
cd /opt/tomcat
sudo chgrp -R tomcat /opt/tomcat
sudo chmod -R g+r conf
sudo chmod g+x conf
sudo chown -R tomcat webapps/ work temp/ logs
```
* To use Tomcat, create systemd service file. Before that get the location of your "JAVA_HOME" path.
```
sudo update-java-alternatives -l
```
or
```
dirname $(dirname $(readlink -f $(which javac)))
```
* Create a file tomcat.service in /etc/systemd/system.
```
sudo vim /etc/systemd/system/tomcat.service
```
* Paste this in that file and add "JAVA_HOME" value that we got before. Save the file.
```
[Unit]
Description=Apache Tomcat Web Application Container
After=network.target

[Service]
Type=forking

Environment=JAVA_HOME=/usr/lib/jvm/java-1.11.0-openjdk-amd64
Environment=CATALINA_PID=/opt/tomcat/latest/temp/tomcat.pid
Environment=CATALINA_HOME=/opt/tomcat
Environment=CATALINA_BASE=/opt/tomcat
Environment=’CATALINA_OPTS=-Xms512M –Xmx1024M –server –XX:+UserParallelGC’
Environment=’JAVA_OPTS=-Djava.awt.headless=true Djava.security.egd=file:/dev/./urandom’

ExecStart=/opt/tomcat/bin/startup.sh
ExecStop=/opt/tomcat/bin/shutdown.sh

User=tomcat
Group=tomcat
UMast=0007
RestartSec=10
Restart=always

[Install]
WantedBy=multi-user.target
```
* Reload the system daemon
```
sudo systemctl daemon-reload
```
* Start the tomcat server
```
sudo systemctl start tomcat
```
* Allow traffic to Port 8080
```
sudo ufw allow 8080/tcp
```
* Open the Tomcat splash page on a browser
```
http://localhost:8080
```
* To give privilege to user to access the web manageme, open this file /opt/tomcat/conf/tomcat-users.xml
```
sudo vim /opt/tomcat/conf/tomcat-users.xml
```
* In the tomcat-users.xml, add this lines inside <tomcat-users>.
```
<tomcat-users>
  <role rolename="admin-gui"/>
  <role rolename="manager-gui"/>
  <role rolename="manager-script"/>
  <user username="tomcat" password="tomcat" roles="admin-gui,manager-gui, manager-script"/>
</tomcat-users>
```
* Restart the server to apply the changes.
```
sudo systemctl restart tomcat
```
* Check this link more information on how to install Tomcat: https://phoenixnap.com/kb/how-to-install-tomcat-ubuntu
* Lets change the maven settings to connect it to use the tomcat server. 
* First, go to maven installation directory. You can check your installation directory by:
```
  mvn -version
```
* Find the settings.xml file. Usually in conf/. Open the file and paste this. Make sure the id, username and password matches.
```
<?xml version="1.0" encoding="UTF-8"?>
<settings ...>
  <servers>
    <server>
      <id>TomcatServer</id>
      <username>tomcat</username>
      <password>tomcat</password>
    </server>
  </servers>
</settings>
```
* All the configuration and installation are done. We can now build and deploy the war file using maven.
  
## Build & Deploy Instructions
* Unzip this project
* Go inside the folder where pom.xml is located
* Clean the project
```
mvn clean
```
* Build the war file
```
mvn install
```
* Deploy the war file to the tomcat server. Make sure the server is on (follow commands given above)
```
mvn tomcat7:deploy
```
* We can now test the project. If we want to redeploy, then
```
mvn tomcat7:redeploy
```
* Once done testing, we can remove the war file from the server using:
```
mvn tomcat7:undeploy
```
* To get the Jacoco unit test coverage, run this command after building the project.
```
mvn jacoco:report
```
* To Jacoco test coverage report is located in /target/site/jacoco/index.html

## Copyright and licensing instructions
MIT License

Copyright (c) 2020 Chintan Patel

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Known bugs
Bugs will be added as founded.

## Credits and acknowledgements
Motivation to do this project came from CS 445 class (Object Oriented Programming Paradigm and Design class). The project was started in March 2020, and submitted in September 2020. Thank you Prof. Virgil Bistriceanu for allowing me to work on this idea. More information about this project is here: http://www.cs.iit.edu/~virgil/cs445/. Contributors to this free software will be highlighted here.
#### Developer of Share A Ride Rest API:
###### Chintan Patel
###### Illinois Institute of Technology
