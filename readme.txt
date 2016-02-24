mvn clean package

java -jar application/target/application-0.0.1-SNAPSHOT.jar server hello-world.yml

sending commands...

curl 'localhost:8080/tictac/?game=0'

curl 'localhost:8080/tictac/move/?game=0&player=1&move=2' -X POST

curl 'localhost:8080/tictac/create/?' -X POST

metrics...

curl 'localhost:8081/metrics?pretty=true'
