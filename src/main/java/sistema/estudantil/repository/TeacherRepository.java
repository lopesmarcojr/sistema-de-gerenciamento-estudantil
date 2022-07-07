package sistema.estudantil.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import sistema.estudantil.entities.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher, String>{

}
