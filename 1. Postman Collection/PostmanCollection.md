## For this project, I am using Google APIs for Cloud Storage to perform CRUD operations along with generating OAuth Access Token. 

*This file includes the details about the postman collection impl.*

**Project Structure**

![Screenshot 2023-09-09 162020](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/313f99cd-1d09-439f-a8f1-d30a7cfdd697)
	
First two requests, are for generating the OAuth Access token to access further APIs of Google Cloud Storage in order to further manipulate the objects

URL endpoint in the first request must be copy pasted in the browser to obtain a code to generate the Auth Access token. In the same URL search bar, it will give you a code as shown in the below screenshot:

![Screenshot 2023-09-09 162620](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/4e7fa376-c882-4772-8eae-71e81ef8d162)

Pass this code in form body under "code" in the second request you will obtain the access token.

This access token can be further used in all the followed by requests in order to access, add and manipulate objects in the Google cloud storage bucket 

