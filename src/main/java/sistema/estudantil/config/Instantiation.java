package sistema.estudantil.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import sistema.estudantil.entities.Teacher;
import sistema.estudantil.repository.AdminRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public void run(String... args) throws Exception {
		/*Configuração para instanciação inicial de dados no banco para fins de teste*/
		
		adminRepository.deleteAll();
		
		Teacher erika = new Teacher(null, "Erika dos Santos", "erika@gmail.com", 12345678);
		Teacher marco = new Teacher(null, "Marco Aurelio", "marco@gmail.com", 654321);
		Teacher ana = new Teacher(null, "Ana Cristina", "ana@gmail.com", 19641203);
		
		adminRepository.saveAll(Arrays.asList(erika,marco,ana));
		
	}

}
