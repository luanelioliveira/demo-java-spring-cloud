format:
	mvn fmt:format -f pom.xml

build:
	mvn clean package -DskipTests

docker_build:
	docker build -t hr-gateway-server:v1 .

docker_run:
	docker run -p 8765:8765 --name hr-gateway-server --network hr-net hr-gateway-server:v1