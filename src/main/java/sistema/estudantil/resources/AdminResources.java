package sistema.estudantil.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sistema.estudantil.dto.AdminDTO;
import sistema.estudantil.entities.Admin;
import sistema.estudantil.entities.Teacher;
import sistema.estudantil.services.AdminServices;

@RestController
@RequestMapping(value = "/admin")
public class AdminResources {
	
	@Autowired
	public AdminServices services;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AdminDTO>> findAll(){
		List<Admin> list = services.findAll();
		List<AdminDTO> listDto = list.stream().map(x -> new AdminDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Teacher>> findAllTeachers(@PathVariable String id){
		Admin admin = services.findById(id);
		return ResponseEntity.ok().body(admin.getTeachers());
	}

}
