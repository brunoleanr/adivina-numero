# ejecutar en desarrollo

./mvnw compile quarkus:dev

# debugear en desarrollo

./mvnw compile quarkus:dev -Ddebug

En Eclipse: Project -> Properties -> Run/Debug Settings -> New... -> Remote Java Application -> Cambiar port a 5005

# compilar quarkus

./mvnw package

# ejecutar quarkus

java -D"quarkus.http.port"=8080 -jar ./target/app-runner.jar

# contruir docker

docker build -f ./src/main/docker/Dockerfile.jvm -t unitech/app .

# ejecutar docker

docker run -it --rm -p 8080:8080 -v C:/git/devops/templates/app-template/app-services/src/main/resources/application.properties:/deployments/config/application.properties -v C:/git/devops/templates/app-template/app-services/src/main/resources/keycloak.json:/deployments/config/keycloak.json unitech/app

# servicios publicos

curl -X GET http://localhost:8080/health

curl -X GET http://localhost:8080/info

curl -X GET http://localhost:8080/public/http-header

curl -X GET http://localhost:8080/public/user -H "X-Auth-Username:test"

curl -X POST http://localhost:8080/public/up -H "Content-Type: multipart/form-data" --form "file=@/mnt/c/tmp/Image.png"

curl -X GET http://localhost:8080/public/keycloak.json

# obtener token de usuario

export TKN=$(curl -X POST 'http://identity.dom.unitech.com.ar/auth/realms/master/protocol/openid-connect/token' -H "Content-Type: application/x-www-form-urlencoded" -d "username=test" -d 'password=test*123' -d 'grant_type=password' -d 'client_id=test' | jq -r '.access_token')

# obtener token de cuenta de servicio

export TKN=$(curl -X POST 'http://identity.dom.unitech.com.ar/auth/realms/master/protocol/openid-connect/token' -d 'grant_type=client_credentials' -d 'client_id=test-service-account' -d 'client_secret=4b1f8c3e-cb12-494c-868c-e00b13c92b5a' | jq -r '.access_token')

# servicios securizados con bearer

curl -X GET http://localhost:8080/secure/http-header -H "Authorization: Bearer $TKN"

curl -X GET http://localhost:8080/secure/user -H "Authorization: Bearer $TKN"