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
## Kafka Event:
patient-created
## Endpoints:
* POST /patient-sql/patient/save
Body: 
```json
{
    "nationalID": 24281311112239,
    "recordNumber": 390,
    "phoneNumber": "01000000001",
    "dateOfBirth": "2021-04-30",
    "firstName": "Mostafa",
    "lastName": "Mostafa",
    "middleName": "Mostafa",
    "gender": 1,
    "photo": "http://host.com/image.jpg",
    "email": "mo2@mo.com",
    "weight": 66.6,
    "height": 180,
    "nationalIDRel": 24281311112229
}
```
* GET /patient-sql/patient/{id}
* GET /patient-sql/patients
----------------------
GET /labrecord-mongo/records
GET /labrecord-mongo/record/{id}
GET /labrecord-mongo/record/patient/{id}
POST /labrecord-mongo/record/save
Body: 
```json
{
  "reportFile": "http://host.com/report4.pdf",
  "date": "2021-12-20T01:14:07.000+00:00",
  "testResult": "Normal",
  "testResultValue": 4,
  "testResultNormalMin": 3,
  "testResultNormalMax": 10,
  "testDescription": "ABCDE test",
  "patient": "24281311112239"
}
```
----------------------
GET relations-service/relations