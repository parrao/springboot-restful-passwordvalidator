
# Springboot  Restful API to validate the password

The rules are:
• Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
• Must be between 5 and 12 characters in length.
• Must not contain any sequence of characters immediately followed by the same sequence.


Application Name: password-validator-ws
Type: SpringBoot App

To Build: mvn clean package
To Run: mvnw spring-boot:run or java -jar target/password-validator-0.0.1-SNAPSHOT.jar


server.port: 9000
management.server.port: 9001
management.server.address: 127.0.0.1

API Details:
URL: http://localhost:9000/services/v1/user/pwvalidate
Method: POST
content-type: application/x-www-form-urlencoded
Params: password=<value>

curl -X POST http://localhost:9000/services/v1/user/pwvalidate  -H 'content-type: application/x-www-form-urlencoded'  -d password=abc123


