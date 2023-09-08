package srishti.codeassessment.googleapi.service;

import com.example.swaggercodegenerationoverview.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import srishti.codeassessment.googleapi.model.TokenFormData;

import java.io.InputStream;
import java.math.BigDecimal;

@Service
public class GoogleApiService{

    String token = "";

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getAccessTheAccessCode(String scope, String responseType, String accessType, String redirectUri, String clientId) {
        String response =  "https://accounts.google.com/o/oauth2/auth?scope=" + scope +
                "&response_type=" + responseType +
                "&access_type=" + accessType +
                "&redirect_uri=" + redirectUri +
                "&client_id=" + clientId;

        return ResponseEntity.ok("Use browser to generate access token by using the below URL:\n\t" + response);
    }

    public ResponseEntity<AccessToken> getAccessTokenAndRefreshToken(String clientId, String clientSecret, String code, String grantType, String redirectUri) {
        try{
            TokenFormData formData = new TokenFormData(grantType, code, clientId, clientSecret, redirectUri);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");

            HttpEntity<TokenFormData> requestEntity = new HttpEntity<>(formData, headers);

            ResponseEntity<AccessToken> response = restTemplate.postForEntity(
                    "https://oauth2.googleapis.com/token",
                    requestEntity,
                    AccessToken.class
            );

            this.token = "Bearer " + response.getBody().getAccessToken();

            return ResponseEntity.ok(response.getBody());
        }
        catch (Exception e){
            return ResponseEntity.status(401).body(null);
        }
    }

    public ResponseEntity<GetObjects> getAllObjectsFromBucketUsingOauth(String targetBucket) {
        if(!this.token.equals("")) {
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", this.token);

                // Create the request entity with the headers
                HttpEntity<?> requestEntity = new HttpEntity<>(headers);

                // Make the request using RestTemplate
                ResponseEntity<GetObjects> response = restTemplate.exchange(
                        "https://storage.googleapis.com/storage/v1/b/" + targetBucket + "/o",
                        HttpMethod.GET,
                        requestEntity,
                        GetObjects.class
                );
                return ResponseEntity.ok(response.getBody());
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(null);
            }
        }
        return ResponseEntity.status(401).body(null);
    }

    public ResponseEntity<UploadObject> uploadingNewObjectToBucket(String targetBucket, MultipartFile file, String uploadType, String name) {
        if(!this.token.equals("")) {
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", this.token);
                headers.add("Content-Type", "image/png");

                InputStream is = file.getInputStream();
                byte[] data = new byte[is.available()];

                HttpEntity<byte[]> requestEntity = new HttpEntity<>(data, headers);

                ResponseEntity<UploadObject> result = restTemplate.postForEntity(
                        "https://storage.googleapis.com/upload/storage/v1/b/"+targetBucket+"/o" +
                                "?uploadType="+uploadType+"&name="+name,
                        requestEntity, UploadObject.class);
                return ResponseEntity.ok(result.getBody());
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(null);
            }
        }
        return ResponseEntity.status(401).body(null);
    }

    public ResponseEntity<CopyObject> copyTheCreatedObject(String sourceBucket, String sourceObject, String targetBucket, String targetObject, OTargetObjectBody body, BigDecimal contentLength) {
        if(!this.token.equals("")) {
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", this.token);
                headers.add("Content-Length", String.valueOf(contentLength));

                HttpEntity<OTargetObjectBody> requestEntity = new HttpEntity<>(body, headers);

                ResponseEntity<CopyObject> result = restTemplate.postForEntity(
                        "https://storage.googleapis.com/storage/v1/b/" + sourceBucket + "/o/" + sourceObject
                                + "/rewriteTo/b/" + targetBucket + "/o/" + targetObject,
                        requestEntity, CopyObject.class
                );

                return ResponseEntity.ok(result.getBody());
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(null);
            }
        }
        return ResponseEntity.status(401).body(null);
    }

    public ResponseEntity<Void> deleteTheCopiedObject(String targetBucket, String targetObject) {
        if(!this.token.equals("")) {
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", this.token);

                HttpEntity<?> requestEntity = new HttpEntity<>(headers);
                restTemplate.exchange(
                        "https://storage.googleapis.com/storage/v1/b/" + targetBucket + "/o/" + targetObject,
                        HttpMethod.DELETE, requestEntity, Void.class
                );
                return ResponseEntity.status(204).body(null);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(null);
            }
        }
        return ResponseEntity.status(401).body(null);
    }
}
