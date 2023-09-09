## For this project, I am using Google APIs for Cloud Storage to perform CRUD operations along with generating OAuth Access Token. 

*This file includes the details about the postman collection impl.*

**Project Structure**

![cf240203607640452c936bdc8cb4ebe3.png](:/8a7061d36c65484f91cb8886fdd0d0f1)
	
First two requests, are for generating the OAuth Access token to access further APIs of Google Cloud Storage in order to further manipulate the objects

URL endpoint in the first request must be copy pasted in the browser to obtain a code to generate the Auth Access token. In the same URL search bar, it will give you a code as shown in the below screenshot:

![3ec07d5ff5843170b5ff7165bf8a468c.png](:/83f15062deef4bb9931adcda91ce2d26)

Pass this code in form body under "code" in the second request you will obtain the access token.

This access token can be further used in all the followed by requests in order to access, add and manipulate objects in the Google cloud storage bucket 

