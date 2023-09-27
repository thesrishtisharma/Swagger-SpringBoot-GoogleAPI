## For this project, I am using Google APIs for Cloud Storage to perform CRUD operations along with generating OAuth Access Token. 

*This file includes the details about the postman collection impl.*

# Google APIs

**Project Structure**

![Screenshot 2023-09-09 170903](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/2a071764-3bda-44f6-b9e3-da00c04e153c)

First two requests, are for generating the OAuth Access token to access further APIs of Google Cloud Storage in order to further manipulate the objects

URL endpoint in the first request must be copy pasted in the browser to obtain a code to generate the Auth Access token. In the same URL search bar, it will give you a code as shown in the below screenshot:

![Screenshot (126)](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/dce76e65-b6cd-4612-9b98-93f14c866856)

Pass this code in form body under "code" in the second request you will obtain the access token.

This access token can be further used in all the followed by requests in order to access, add and manipulate objects in the Google cloud storage bucket 

# Spring Boot - Google API IMPL

![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/3f1615fb-0a77-4b3f-aabe-00ec4ce86c34)

# Data Collector Service

![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/b9c539f3-a791-4f61-adcd-1e0b4c537543)

# Spring Security : JWT Token

![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/d63154e9-7ebd-48f5-89d5-8a361b58ec59)

Since I used H2 in memory database, hence adding users to database is unlocked, so that for testing purpose first a user can be added to the db:
  ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/4574e08a-bff4-46ac-b022-df1cb8135547)

Generating JWT Token for authentication:
  ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/64633d7d-753c-467a-b870-b48135a43fee)

This token can be used in further requests for authentication purpose as:
  ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/5670e189-5e85-4212-9f42-cb1aa6452f3f)
