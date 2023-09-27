## For this project, I am using Google APIs for Cloud Storage to perform CRUD operations along with generating OAuth Access Token. 

*This file includes the details about the postman collection impl.*

**Project Structure**

![Screenshot 2023-09-09 170903](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/2a071764-3bda-44f6-b9e3-da00c04e153c)

First two requests, are for generating the OAuth Access token to access further APIs of Google Cloud Storage in order to further manipulate the objects

URL endpoint in the first request must be copy pasted in the browser to obtain a code to generate the Auth Access token. In the same URL search bar, it will give you a code as shown in the below screenshot:

![Screenshot (126)](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/dce76e65-b6cd-4612-9b98-93f14c866856)

Pass this code in form body under "code" in the second request you will obtain the access token.

This access token can be further used in all the followed by requests in order to access, add and manipulate objects in the Google cloud storage bucket 

