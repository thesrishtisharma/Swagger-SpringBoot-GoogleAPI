package srishti.codeassessment.googleapi.controller;

import com.example.swaggercodegenerationoverview.api.OApi;
import com.example.swaggercodegenerationoverview.api.StorageApi;
import com.example.swaggercodegenerationoverview.api.TokenApi;
import com.example.swaggercodegenerationoverview.api.UploadApi;
import com.example.swaggercodegenerationoverview.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import srishti.codeassessment.googleapi.service.GoogleApiService;

import java.math.BigDecimal;

@RestController
public class GcpApiController implements OApi, TokenApi, UploadApi, StorageApi {

    @Autowired
    private GoogleApiService googleApiService;

    @Override
    public ResponseEntity<String> getAccessTheAccessCode(String scope, String responseType, String accessType, String redirectUri, String clientId) {
        return googleApiService.getAccessTheAccessCode(scope, responseType, accessType, redirectUri, clientId);
    }

    @Override
    public ResponseEntity<AccessToken> getAccessTokenAndRefreshToken(String clientId, String clientSecret, String code, String grantType, String redirectUri) {
        return googleApiService.getAccessTokenAndRefreshToken(clientId, clientSecret, code, grantType, redirectUri);
    }

    @Override
    public ResponseEntity<GetObjects> getAllObjectsFromBucketUsingOauth(String targetBucket) {
        return googleApiService.getAllObjectsFromBucketUsingOauth(targetBucket);
    }

    @Override
    public ResponseEntity<UploadObject> uploadingNewObjectToBucket(String targetBucket, MultipartFile file, String uploadType, String name) {
        return googleApiService.uploadingNewObjectToBucket(targetBucket, file, uploadType, name);
    }

    @Override
    public ResponseEntity<CopyObject> copyTheCreatedObject(String sourceBucket, String sourceObject, String targetBucket, String targetObject, OTargetObjectBody body, BigDecimal contentLength) {
        return googleApiService.copyTheCreatedObject(sourceBucket, sourceObject, targetBucket, targetObject, body, contentLength);
    }

    @Override
    public ResponseEntity<Void> deleteTheCopiedObject(String targetBucket, String targetObject) {
        return googleApiService.deleteTheCopiedObject(targetBucket, targetObject);
    }

}
