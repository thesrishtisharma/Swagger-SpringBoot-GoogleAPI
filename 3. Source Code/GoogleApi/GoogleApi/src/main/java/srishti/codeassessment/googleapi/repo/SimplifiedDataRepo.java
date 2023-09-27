package srishti.codeassessment.googleapi.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import srishti.codeassessment.googleapi.model.SimplifiedData;

import java.util.List;

@Repository
public interface SimplifiedDataRepo extends JpaRepository<SimplifiedData, Long> {

    SimplifiedData findByName(String name);
}
