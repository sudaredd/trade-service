# trade-service

To build this project, download trade-service and import pom.xml from trade-service-build

This project is implemented with various microservices, all are communicated with Kafka, Spring cloud, Eureka server and client.

1) trade-exch generaes fix message and drop to Kafka
2) trade-processor subscribe to Kafka and call eureka client microservices (trading-account-service, counterparty-service, 
   financial-product-service and product-service)  to add enrichments. All these eureka clients regiser with Eureka server
3) trade-eureka-server is an application that holds the information about all client-service applications. 

