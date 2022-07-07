package sistema.estudantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.estudantil.dto.TeacherDTO;
import sistema.estudantil.entities.Teacher;
import sistema.estudantil.repository.TeacherRepository;
import sistema.estudantil.services.exception.ObjectNotFoundException;

@Service
public class TeacherServices {

	
	@Autowired
	private TeacherRepository repository;
	
	public List<Teacher> findAll() {
		return repository.findAll();
	}
	
	public Teacher findById(String id) {
		Optional<Teacher> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Teacher insert(Teacher obj) {
		return repository.insert(obj);
	}
	
	public Teacher update(Teacher obj) {
		Optional<Teacher> newObj = repository.findById(obj.getId());
		Teacher teacher = newObj.get();
		updateDate(teacher, obj);
		return repository.save(teacher);
}

	private void updateDate(Teacher teacher, Teacher obj) {
		teacher.setName(obj.getName());
		teacher.setEmail(obj.getEmail());
		teacher.setRegistration(obj.getRegistration());
		
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Teacher fromDTO(TeacherDTO teacherDto) {
		return new Teacher(teacherDto.getId(), teacherDto.getName(), teacherDto.getEmail(), teacherDto.getRegistration());
	}

}