format:
	@mvn fmt:format -f pom.xml

build:
	@mvn clean package

docker_build:
	@docker build -t hr-config-server:v1 .

docker_run:
	@docker run -p 8888:8888 --name hr-config-server --network hr-net -e GI_USERNAME=${GIT_USERNAME} -e GIT_PASSWORD=${GIT_PASS} hr-config-server:v1
