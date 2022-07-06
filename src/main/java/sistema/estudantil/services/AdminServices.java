package sistema.estudantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.estudantil.entities.Admin;
import sistema.estudantil.repository.AdminRepository;
import sistema.estudantil.services.exception.ObjectNotFoundException;

@Service
public class AdminServices {
	
	@Autowired
	public AdminRepository repository;
	
	public List<Admin> findAll() {
		return repository.findAll();
	}
	
	public Admin findById(String id) {
		Optional<Admin> admin = repository.findById(id);
		return admin.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
