# ejecutar en desarrollo

npm install

ng serve

# versionar (Actualiza archivo info.json)

npm run updateBuild -- VERSION

# antes de construir, limpiar carpeta /dist

npm run clean

# compilar ng

npm run-script build

# contruir docker

docker build -f ./docker/Dockerfile -t unitech/ui .

# ejecutar docker

docker run -it --rm -p 80:80 unitech/ui

# acceder

http://localhost

# servicios publicos

curl -X GET http://localhost/health

curl -X GET http://localhost/info