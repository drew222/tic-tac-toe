mvn clean package

java -jar application/target/application-0.0.1-SNAPSHOT.jar server hello-world.yml

sending commands...

curl 'localhost:8080/hello-world/'

curl 'localhost:8080/hello-world/?player=1&move=2' -X POST
