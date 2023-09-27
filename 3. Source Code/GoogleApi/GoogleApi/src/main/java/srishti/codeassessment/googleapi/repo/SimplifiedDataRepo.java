package srishti.codeassessment.googleapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import srishti.codeassessment.googleapi.model.SimplifiedData;

@Repository
public interface SimplifiedDataRepo extends JpaRepository<SimplifiedData, Long> {

    SimplifiedData findByName(String name);
}
