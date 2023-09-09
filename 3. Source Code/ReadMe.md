## Step 3 - Use Open API (.yaml) file to generate spring boot code 

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

  
