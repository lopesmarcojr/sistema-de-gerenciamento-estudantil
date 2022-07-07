package sistema.estudantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.estudantil.dto.StudentDTO;
import sistema.estudantil.entities.Student;
import sistema.estudantil.repository.StudentRepository;
import sistema.estudantil.services.exception.ObjectNotFoundException;

@Service
public class StudentServices {
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> findAll(){
		return repository.findAll();
	}
	
	public Student findById(String id) {
		Optional<Student> student = repository.findById(id);
		return student.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Student insert(Student obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Student update(Student obj) {
		Optional<Student> newObj = repository.findById(obj.getId());
		Student student = newObj.get();
		updateData(student,obj);
		return repository.save(student);
	}

	private void updateData(Student student, Student obj) {
		student.setName(obj.getName());
		student.setEmail(obj.getEmail());
		student.setRegistration(obj.getRegistration());
	}
	
	public Student fromDTO(StudentDTO studentDto) {
		return new Student(studentDto.getId(), studentDto.getName(), studentDto.getEmail(), studentDto.getRegistration());
		
	}

}
