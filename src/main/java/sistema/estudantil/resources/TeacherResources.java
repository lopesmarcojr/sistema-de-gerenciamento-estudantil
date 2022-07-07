package sistema.estudantil.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sistema.estudantil.dto.TeacherDTO;
import sistema.estudantil.entities.Teacher;
import sistema.estudantil.services.TeacherServices;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherResources {
	
	@Autowired
	private TeacherServices services;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TeacherDTO>> findAll(){
		List<Teacher> list = services.findAll();
		List<TeacherDTO> listDto = list.stream().map(x -> new TeacherDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<TeacherDTO> findById(@PathVariable String id) {
		Teacher teacher = services.findById(id);
		return ResponseEntity.ok().body(new TeacherDTO(teacher));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Teacher> insert(@RequestBody Teacher obj){
		obj = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id,@RequestBody TeacherDTO teacherDto){
		Teacher obj = services.fromDTO(teacherDto);
		obj.setId(id);
		obj = services.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}

}
