package sistema.estudantil.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sistema.estudantil.entities.Grade;

@Repository
public interface GradeRepository extends MongoRepository<Grade, String>{

}
