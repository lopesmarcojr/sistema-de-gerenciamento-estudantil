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

import sistema.estudantil.dto.SubjectDTO;
import sistema.estudantil.entities.Subject;
import sistema.estudantil.services.SubjectServices;

@RestController
@RequestMapping(value = "/subject")
public class SubjectResources {
	
	@Autowired
	private SubjectServices services;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SubjectDTO>> findAll(){
		List<Subject> list = services.findAll();
		List<SubjectDTO> listDto = list.stream().map(x -> new SubjectDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<SubjectDTO> findById(@PathVariable String id){
		Subject subject = services.findById(id);
		return ResponseEntity.ok().body(new SubjectDTO(subject));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Subject> insert(@RequestBody Subject obj){
		obj = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Subject> update(@RequestBody SubjectDTO subjectDto,@PathVariable String id){
		Subject obj = services.fromDTO(subjectDto);
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
