package sistema.estudantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.estudantil.dto.GradeDTO;
import sistema.estudantil.entities.Grade;
import sistema.estudantil.repository.GradeRepository;
import sistema.estudantil.services.exception.ObjectNotFoundException;

@Service
public class GradeServices {

	@Autowired
	private GradeRepository repository;

	public List<Grade> findAll() {
		return repository.findAll();
	}

	public Grade findById(String id) {
		Optional<Grade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Grade insert(Grade obj) {
		return repository.insert(obj);
	}

	public Grade update(Grade obj) {
		Optional<Grade> newObj = repository.findById(obj.getId());
		Grade grade = newObj.get();
		updateData(grade, obj);
		return repository.save(grade);
	}

	private void updateData(Grade grade, Grade obj) {
		grade.setId(obj.getId());
		grade.setSubjectGrade(obj.getSubjectGrade());
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public Grade fromDTO(GradeDTO gradeDto) {
		return new Grade(gradeDto.getId(), gradeDto.getSubjetctGrade());
	}
}
