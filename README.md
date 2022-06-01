# EMR-microservices
## Package projects
mvn package -DskipTests for java projects
## Run:
* Pull images:
    * docker pull moustafaomar/microservices:eureka
    * docker pull moustafaomar/microservices:zuul
    * docker pull moustafaomar/microservices:patients
    * docker pull moustafaomar/microservices:RelationsService
    * docker pull moustafaomar/microservices:LabRecord
* Run docker compose
    * docker-compose up