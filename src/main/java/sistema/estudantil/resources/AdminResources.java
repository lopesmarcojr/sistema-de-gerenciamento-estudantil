package sistema.estudantil.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sistema.estudantil.entities.Teacher;

@RestController
@RequestMapping(value = "/admin")
public class AdminResources {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Teacher>> findAll(){
		List<Teacher> list = new ArrayList<>();
		Teacher erika = new Teacher("1", "Erika", "erika@gmail.com", 123456);
		Teacher marco = new Teacher("2", "Marco", "marco@gmail.com", 654321);
		list.addAll(Arrays.asList(erika,marco));
		return ResponseEntity.ok().body(list);
	}

}
