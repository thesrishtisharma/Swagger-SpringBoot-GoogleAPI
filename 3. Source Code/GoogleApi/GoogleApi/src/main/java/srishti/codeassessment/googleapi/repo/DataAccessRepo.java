package srishti.codeassessment.googleapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import srishti.codeassessment.googleapi.model.DataAccess;

@Repository
public interface DataAccessRepo extends JpaRepository<DataAccess, String> {

    DataAccess findByUsername(String username);
}
