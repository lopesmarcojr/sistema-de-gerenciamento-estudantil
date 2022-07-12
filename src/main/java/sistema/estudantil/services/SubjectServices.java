package sistema.estudantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.estudantil.dto.SubjectDTO;
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
	
	public Subject insert(Subject obj) {
		return repository.insert(obj);
	}
	
	public Subject update(Subject obj) {
		Optional<Subject> newObj = repository.findById(obj.getId());
		Subject subject = newObj.get();
		updateData(subject, obj);
		return repository.save(subject);
	}

	private void updateData(Subject subject, Subject obj) {
		subject.setId(obj.getId());
		subject.setName(obj.getName());
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public Subject fromDTO(SubjectDTO subjectDto) {
		return new Subject(subjectDto.getId(), subjectDto.getName());
	}

}
