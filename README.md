# Welcome

This is an **binlist.net** API implementation.
# Binlist(.)net

binlist.net is a public web service for looking up credit and debit card meta data.

## IIN / BIN

The first 6 or 8 digits of a payment card number (credit cards, debit cards, etc.) are known as the  [Issuer Identification Numbers (IIN)](https://en.wikipedia.org/wiki/Payment_card_number#Issuer_identification_number_.28IIN.29), previously known as Bank Identification Number (BIN). These identify the institution that issued the card to the card holder.



# To run this on 

## your Local System
clone the repository on your system.
> git clone https://github.com/isupersky/CreditSaison-INN-Lookup

create a database with a name of your choice.
  
then go to `application.properties` file in `src/main/resources` folder and update the the following code 
>spring.datasource.url=jdbc:mysql://localhost:3306/</your database name>  
spring.datasource.username=</your database username>
spring.datasource.password=</your database password>

You are good to go now. If you are using an IDE, just hit run
else use the following commands
>./gradlew clean build

>java -jar CreditSaison-INN-Lookup/build/libs/CreditSaison-INN-Lookup-0.0.1-SNAPSHOT.jar



##  Docker
Run the following command from inside the Project directory
>docker build -t version:1.0 .

there is a dot(.) at the end of the above command, don't forget that.
>docker run --network connection --name one-container -p 8080:8080 -d version:1.0

# Postman Api Collection
use the following [link](https://www.getpostman.com/collections/7bdcf2e346ca348b3cae) or the below mentioned curl request to import the API collection.

> {"info":{"_postman_id":"e36b1ddf-1e31-478a-aaee-fc77217c2ec2","name":"Postman","schema":"https://schema.getpostman.com/json/collection/v2.0.0/collection.json"},"item":[{"name":"https://34.70.30.55:8080/card-scheme/stats","id":"0ea7b89a-a42e-4065-a160-ac77586bba37","protocolProfileBehavior":{"disableBodyPruning":true},"request":{"method":"GET","header":[{"key":"Accept-Version","value":"3"}],"body":{"mode":"formdata","formdata":[{"key":"start","value":"1","type":"text"},{"key":"limit","value":"10","type":"text"}]},"url":"https://34.70.30.55:8080/card-scheme/stats"},"response":[]},{"name":"http://34.70.30.55:8080/card-scheme/verify/371554","id":"264745f3-4800-44c2-b594-43833a2d0f3e","request":{"method":"GET","header":[{"key":"Accept-Version","value":"3"}],"url":"http://34.70.30.55:8080/card-scheme/verify/371554"},"response":[]}]}

