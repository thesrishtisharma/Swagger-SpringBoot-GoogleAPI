package srishti.codeassessment.googleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import srishti.codeassessment.googleapi.repo.SimplifiedDataRepo;
import srishti.codeassessment.googleapi.model.SimplifiedData;

import java.util.List;

@Service
public class SimplifiedDataService {

    @Value("${fetch_max_limit}")
    private int maxLimit;

    @Autowired
    private SimplifiedDataRepo simplifiedDataRepo;

    // Whenever an object is created or updated the details in the simplified structure should also update
    public void updateSimplifiedData(SimplifiedData dataObj){
        SimplifiedData temp = simplifiedDataRepo.findByName(dataObj.getName());
        if(temp != null) {
            dataObj.setUnix();
            dataObj.setOperation("Update");
        }
        else
            dataObj.setOperation("New");
        simplifiedDataRepo.save(dataObj);
        System.out.println("Request meta data added to the database");
    }

    public List<SimplifiedData> getRecords(){
        Pageable pageable = PageRequest.of(0, maxLimit);
        return simplifiedDataRepo.findAll(pageable).getContent();
    }
}