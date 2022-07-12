package sistema.estudantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.estudantil.entities.Subject;
import sistema.estudantil.repository.SubjectRepository;
import sistema.estudantil.services.exception.ObjectNotFoundException;

@Service
public class SubjectServices {
	
	@Autowired
	private SubjectRepository repository;
	
	public List<Subject> findAll(){
		return repository.findAll();
	}
	
	public Subject findById(String id) {
		Optional<Subject> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
