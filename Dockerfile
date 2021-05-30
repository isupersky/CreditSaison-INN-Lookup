FROM openjdk:8-alpine
WORKDIR /root
ADD ~/CreditSaison-INN-Lookup/build/libs/CreditSaison-INN-Lookup-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","CreditSaison-INN-Lookup-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080