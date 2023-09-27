package srishti.codeassessment.googleapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import srishti.codeassessment.googleapi.model.SimplifiedData;
import srishti.codeassessment.googleapi.service.SimplifiedDataService;

import java.util.List;

@RestController
@RequestMapping("data-controller")
public class SimplifiedDataController {

    @Autowired
    private SimplifiedDataService simplifiedDataService;

    @GetMapping("/limited-records")
    public List<SimplifiedData> getLimitedRecords(){
        return simplifiedDataService.getRecords();
    }
}
