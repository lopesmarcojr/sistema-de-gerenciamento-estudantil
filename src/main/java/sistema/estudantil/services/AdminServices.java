package sistema.estudantil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.estudantil.entities.Admin;
import sistema.estudantil.repository.AdminRepository;

@Service
public class AdminServices {
	
	@Autowired
	public AdminRepository repository;
	
	public List<Admin> findAll() {
		return repository.findAll();
	}
	
}
