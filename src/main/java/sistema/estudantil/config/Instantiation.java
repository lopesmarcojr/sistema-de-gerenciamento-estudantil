package sistema.estudantil.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import sistema.estudantil.entities.Admin;
import sistema.estudantil.repository.AdminRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public void run(String... args) throws Exception {
		/*Configuração para instanciação inicial de dados no banco para fins de teste*/
		
		adminRepository.deleteAll();
		
		Admin erika = new Admin(null, "Erika dos Santos", "erika@gmail.com");
		Admin marco = new Admin(null, "Marco Aurelio", "marco@gmail.com");
		Admin ana = new Admin(null, "Ana Cristina", "ana@gmail.com");
		
		adminRepository.saveAll(Arrays.asList(erika,marco,ana));
		
	}

}
