#### Description:

Create Spring Boot project with REST API.<br/>
Document methods using Swagger annotations.

#### Check out sources:
`git clone https://github.com/forbrock/rest-api-demo.git`

##### ***IMPORTANT! All commands below execute from the project root***

#### Build jar file:
`./mvnw clean package`

#### Run the application:
`./mvnw spring-boot:run`

API urls:

- `GET http://localhost:8080/api/customers`: get all customers
- `GET http://localhost:8080/api/customers/{id}`: get customer by `id`
- `POST http://localhost:8080/api/customers`: create new customer
- `PATCH http://localhost:8080/api/customers/{id}`: update any field of customer by `id`
- `DELETE http://localhost:8080/api/customers/{id}`: delete customer by `id`

OpenAPI definition:<br/>
http://localhost:8080/swagger-ui/index.html