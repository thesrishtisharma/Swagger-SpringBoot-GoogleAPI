## For this project, I am using Google APIs for Cloud Storage to perform CRUD operations along with generating OAuth Access Token. 

*This file includes the details about the postman collection impl.*

**Project Structure**

[![https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/blob/master/4.%20Images%20Repo%20for%20ReadMe/Screenshot%202023-09-09%20162020.png](:/9895db94564248f2a9ff76da6de2920c)]
	
First two requests, are for generating the OAuth Access token to access further APIs of Google Cloud Storage in order to further manipulate the objects

URL endpoint in the first request must be copy pasted in the browser to obtain a code to generate the Auth Access token. In the same URL search bar, it will give you a code as shown in the below screenshot:

![fbb74e1de9108602d9700094e557ced5.png](:/ac656f7529b747d6a23bb959aa374799)

Pass this code in form body under "code" in the second request you will obtain the access token.

This access token can be further used in all the followed by requests in order to access, add and manipulate objects in the Google cloud storage bucket 

