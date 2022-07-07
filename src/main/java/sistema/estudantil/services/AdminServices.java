package sistema.estudantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.estudantil.dto.AdminDTO;
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
	
	public Admin insert(Admin obj) {
		return repository.insert(obj);
	}
	
	
	public Admin update(Admin obj) {
		Optional<Admin> newObj = repository.findById(obj.getId());
		Admin admin = newObj.get();
		updateData(admin, obj);
		return repository.save(admin);
	}

	private void updateData(Admin admin, Admin obj) {
		admin.setName(obj.getName());
		admin.setEmail(obj.getEmail());
		
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Admin fromDTO(AdminDTO adminDto) {
		return new Admin(adminDto.getId(),adminDto.getName(), adminDto.getEmail());
	}
}
