package srishti.codeassessment.googleapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import srishti.codeassessment.googleapi.model.DataAccess;
import srishti.codeassessment.googleapi.service.DataAccessService;

@RestController
public class DataAccessController {

    @Autowired
    private DataAccessService accessService;

    @PostMapping("/add-user")
    public DataAccess addUser(@RequestBody DataAccess userObj){
        return accessService.newUser(userObj);
    }
}
