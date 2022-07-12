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

import sistema.estudantil.dto.GradeDTO;
import sistema.estudantil.entities.Grade;
import sistema.estudantil.services.GradeServices;

@RestController
@RequestMapping(value = "/grades")
public class GradeResources {

	@Autowired
	private GradeServices services;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<GradeDTO>> findALl(){
		List<Grade> list = services.findAll();
		List<GradeDTO> listDto = list.stream().map(x -> new GradeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<GradeDTO> findById(@PathVariable String id){
		Grade grade = services.findById(id);
		return ResponseEntity.ok().body(new GradeDTO(grade));
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Grade> insert(@RequestBody Grade obj){
		obj = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Grade> update(@PathVariable String id, @RequestBody GradeDTO gradeDto){
		Grade obj = services.fromDTO(gradeDto);
		obj.setId(id);
		obj = services.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(String id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}
