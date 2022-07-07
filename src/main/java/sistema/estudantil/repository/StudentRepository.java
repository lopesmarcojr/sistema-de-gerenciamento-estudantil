package sistema.estudantil.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sistema.estudantil.entities.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

}
