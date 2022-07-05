package sistema.estudantil.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sistema.estudantil.entities.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{

}
