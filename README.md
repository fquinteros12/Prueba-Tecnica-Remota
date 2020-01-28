Prueba Técnica Remota

Build:

mvn clean package


Run:

java -jar target/pruebatecnica-dropwizard.jar server config.yml

Docker

docker build -t pruebatecnica-dropwizard

docker run -it -p 9001:9001 -e ENV_VARIABLE_VERSION=1.1.1 pruebatecnica-dropwizard

Funcionalidades:

Movies:
	Database donde se puede agregar, editar o remover peliculas mediante JSON.
	Endpoint: 
	
		  GET: http://localhost:9000/movie/all		  
		  GET: http://localhost:9000/movie/get/{id}
		  GET: http://localhost:9000/movie/remove
		  
		  POST: http://localhost:9000/movie/save
		  
Ademas se dispone de un collection en POSTMAN para las pruebas.
