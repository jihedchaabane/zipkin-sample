
sudo systemctl start jenkins

sudo systemctl start docker

sudo systemctl enable docker

chmod 777 /var/run/docker.sock

# OR permanently ---

sudo groupadd docker

sudo usermod -aG docker jenkins

sudo systemctl restart jenkins

groups jenkins

#------------------------------

java -jar zipkin-server-2.24.3-exec.jar

http://localhost:9411

sudo firewall-cmd --permanent --add-port=9411/tcp

sudo firewall-cmd --reload

sudo firewall-cmd --list-ports

#------------------------------