## Step 3 - Use Open API (.yaml) file to generate spring boot code 

# Task 1
1. Keep the file in resources folder
  
   ![Screenshot 2023-09-09 171332](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/f7e49688-59b8-4d59-b13a-2dfb5da46ac4)


2. Edit the POM as mentioned in the below screenshot. This code will help to generate resources automatically using the Open API Specifications (.yaml) file
     
  ![Screenshot 2023-09-09 171452](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/2a5eebb7-4b27-42f5-a40e-7322e88b478a)

   As shown in the above image, once you have the build pligin setup done correctly, it will generate project structure using open API specification (in the left pf the screenshot). And will create 2 sub folders, api & model, comprising of everything you'll need to run the code.

3. For the above build settings to work properly, there are some dependencies that will be needed in the project, please refer to the required dependencies below:

     ![Screenshot 2023-09-09 165933](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/354abaf1-78a0-434d-aece-7f8a28215f74)


4. Now you just need to implement the interfaces that are automatically generated (under target folder) in your RestController. As shown in the below screenshot:

    ![Screenshot 2023-09-09 170241](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/d3e5db24-01df-4fb9-b187-3566a4bd3fe4)


5. Provide all the custom logic that you would want these functions to implement in the Service class to maintain security and SOLID principles of programming design.

6. Thats All! Now you can run these APIs using your postman. I have the local host APIs also implemented in the "Postman Collection" of this repository. Please check that out if you face any issues. Howver, attached below is the heirarchy of the Local Host APIs :

    ![Screenshot 2023-09-09 170517](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/ade0855e-c8c2-4f9b-a789-c33c2429e193)

  
# Task 2

1. For a selected API, push the triggers meta data in a simplied format into a database (Using H2 database)
    1.1. First add the dependency:
         ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/1e9f39dd-8e24-4c49-860f-8508c35e8111)

    1.2. Once added, create an entity class to hold the meta data in a simplified format:
         ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/5667eb2b-6a8f-432b-80d9-a66513b1c752)

    1.3. Create Repo to connect this entity class with the actual database along with a service class to perform the implementation logics
         Repo Interface:
           ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/1adec574-ecb8-4af8-a218-6d5f7785a84c)

         Service Class:
           ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/73d9242a-55c3-4509-8bee-cd963c8c36cc)

    1.4. For the impl logic, I have saved the triggers to the database, when a new object is uploaded:
         ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/58762aef-c524-4141-aeb8-702d09307f2d)

_Note: whenever a new object is created/uploaded to GCP bucket the required meta data is stored in the database. Also, since GCP can have only 1 object with 1 name, however when an API is triggered with the same name GCP considers that this object is modified. Hence that duplicated records is not being saved in the database however, the unix timestamp is modified with the latest time._

2. The details in the database can be accesses via an authenticated user only. In order to handle that, I have implemented Spring Security which allows authenitcation to the users that exists in the database using JWT Bearer Token. Also, password of this class is saved after encryption using BCryptPasswordEncoder.

   2.1. POJO class:
       ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/1641235c-fa82-48a8-8412-15462caa3c89)


   2.2. Service and Repo Class:
      ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/ed5363e8-fe92-4607-b5f6-35180fbc2c00)

       ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/2083e271-aeef-4255-bca7-35490ec79ead)

3. Spring Security IMPL:
    Dependency:
       ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/b07586a5-7482-42ae-b3cb-9d6642b20225)

    Password Encoder:
       ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/9b91c62c-4f04-4594-bb5d-29054f5fbd9f)

    Security Config:
       ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/832af118-5581-4c1f-a171-befd555e3275)

    Entry Point Authentication via JWT
       ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/ae4f216f-b003-45dd-aed4-44c8f58c048f)

    Token Validation:
       ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/c8496d30-cb41-48b4-b69c-fac72187ac40)

    Authentication Code:
       ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/2e07d73f-f802-4a66-8e07-3240cff8cc5f)

    Custom User Details Service to authenticate using database records:
       ![image](https://github.com/thesrishtisharma/Swagger-SpringBoot-GoogleAPI/assets/38985008/308a0aa7-49a0-4eb1-bb16-1d91ac6165e3)

	         
