package sistema.estudantil.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sistema.estudantil.entities.Teacher;
import sistema.estudantil.services.AdminServices;

@RestController
@RequestMapping(value = "/admin")
public class AdminResources {
	
	@Autowired
	public AdminServices services;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Teacher>> findAll(){
		List<Teacher> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}

}
