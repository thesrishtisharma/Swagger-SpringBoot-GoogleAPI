package srishti.codeassessment.googleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import srishti.codeassessment.googleapi.model.DataAccess;
import srishti.codeassessment.googleapi.repo.DataAccessRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private DataAccessRepo dataAccessRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // loads users from database
        DataAccess userObj = this.dataAccessRepo.findByEmail(username);
        if(userObj == null)
            throw new UsernameNotFoundException("User not found in database !!");

        return userObj;
    }
}
