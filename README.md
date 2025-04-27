
sudo systemctl start jenkins \
sudo systemctl start docker \
sudo systemctl enable docker

chmod 777 /var/run/docker.sock

# OR permanently --- \

sudo groupadd docker \
sudo usermod -aG docker jenkins \
sudo systemctl restart jenkins \
groups jenkins

#------------------------------

docker run -d --name zipkin -p 9411:9411 openzipkin/zipkin \
http://localhost:9411

sudo firewall-cmd --permanent --add-port=9411/tcp \
sudo firewall-cmd --reload \
sudo firewall-cmd --list-ports

#------------------------------

Configurer le job Jenkins: \
	Créer un nouveau job : \
		Allez dans Jenkins > "Nouveau Item" > Choisissez "Pipeline" et donnez un nom (par exemple, zipkin-sample--docker-Jenkinsfile-ms1). \
	Configurer la source du code : \
		Dans la section "Pipeline", sélectionnez Pipeline SCM. \
		Choisissez votre système de contrôle de version (Git). \
			Indiquez l'URL de votre dépôt Git et les identifiants si nécessaires. \
			Dans "Script Path", spécifiez le chemin du Jenkinsfile (par défaut : Jenkinsfile si à la racine, ou par exemple gr-conf-zipkin-client-ms1/Jenkinsfile si dans le module). \
	Configurer les identifiants Docker (si nécessaire) : \
		Si vous poussez l'image vers un registre privé (comme Docker Hub), ajoutez les identifiants dans Manage Jenkins > Manage Plugins > Credentials. \
		Créez un identifiant de type "Username with Password" pour Docker Hub. \
		Référencez cet identifiant dans le Jenkinsfile avec docker.withRegistry (décommentez la section correspondante). \
#------------------------------

docker run -d --name ${CONTAINER_NAME} -p ${APP_PORT}:${APP_PORT} \
    --link ${ZIPKIN_CONTAINER_NAME}:zipkin \
    -e SPRING_ZIPKIN_BASE_URL=http://zipkin:9411 ${DOCKER_IMAGE} \
	
	--link ${ZIPKIN_CONTAINER_NAME}:zipkin : Lie le conteneur de l'application au conteneur Zipkin, permettant à l'application de résoudre zipkin comme nom d'hôte. \
	-e SPRING_ZIPKIN_BASE_URL=http://zipkin:9411 : Configure l'URL de Zipkin pour pointer vers le conteneur Zipkin sur le port 9411.

#------------------------------

Surveiller les performances: \
L'intégration avec Zipkin peut générer une surcharge si votre application envoie beaucoup de traces. \
Pour un environnement de test comme la pipeline Jenkins, vous pouvez envisager de désactiver Zipkin temporairement (si ce n'est pas critique) \ 
pour réduire le temps d'exécution : \
docker run -d --name ${CONTAINER_NAME} --network ${DOCKER_NETWORK} -p ${APP_PORT}:${APP_PORT} \
    -e SPRING_ZIPKIN_ENABLED=false ${DOCKER_IMAGE} \
#------------------------------ \