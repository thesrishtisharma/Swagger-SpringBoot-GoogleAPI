package srishti.codeassessment.googleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import srishti.codeassessment.googleapi.model.DataAccess;
import srishti.codeassessment.googleapi.repo.DataAccessRepo;

import java.util.List;

@Service
public class DataAccessService {

    @Autowired
    private DataAccessRepo dataAccessRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<DataAccess> allUsers(){
        return this.dataAccessRepo.findAll();
    }

    public DataAccess findUserByUsername(DataAccess userObj){
        return this.dataAccessRepo.findByUsername(userObj.getUsername());
    }

    public DataAccess newUser(DataAccess userObj){
        userObj.setPassword(this.passwordEncoder.encode(userObj.getPassword()));
        return this.dataAccessRepo.save(userObj);
    }
}
