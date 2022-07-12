package sistema.estudantil.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sistema.estudantil.entities.Subject;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String>{

}
