
sudo systemctl start jenkins

sudo systemctl start docker

sudo systemctl enable docker

chmod 777 /var/run/docker.sock

#------------------------------

sudo groupadd docker

sudo usermod -aG docker jenkins

sudo systemctl restart jenkins

groups jenkins

