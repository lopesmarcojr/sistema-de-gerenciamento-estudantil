package sistema.estudantil.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import sistema.estudantil.entities.Admin;
import sistema.estudantil.entities.Grade;
import sistema.estudantil.entities.Student;
import sistema.estudantil.entities.Subject;
import sistema.estudantil.entities.Teacher;
import sistema.estudantil.repository.AdminRepository;
import sistema.estudantil.repository.GradeRepository;
import sistema.estudantil.repository.StudentRepository;
import sistema.estudantil.repository.SubjectRepository;
import sistema.estudantil.repository.TeacherRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public void run(String... args) throws Exception {
		/*Configuração para instanciação inicial de dados no banco para fins de teste*/
		
		adminRepository.deleteAll();
		
		Admin erika = new Admin(null, "Erika dos Santos", "erika@gmail.com");
		Admin marco = new Admin(null, "Marco Aurelio", "marco@gmail.com");
		Admin ana = new Admin(null, "Ana Cristina", "ana@gmail.com");
		
		adminRepository.saveAll(Arrays.asList(erika,marco,ana));
		
		teacherRepository.deleteAll();
		
		Teacher random1 = new Teacher(null, "Random dos Santos", "random1@gmail.com", 12345678);
		Teacher random2 = new Teacher(null, "Random Dois dos Santos", "random2@gmail.com", 12345678);
		Teacher random3 = new Teacher(null, "Random Três dos Santos", "random3@gmail.com", 12345678);
		
		teacherRepository.saveAll(Arrays.asList(random1,random2,random3));
		
		studentRepository.deleteAll();
		
		Student random4 = new Student(null, "Aluno dos Santos Um", "aluno1@gmail.com", 123456);
		Student random5 = new Student(null, "Aluno dos Santos Dois", "aluno2@gmail.com", 654321);
		Student random6= new Student(null, "Aluno dos Santos Três", "aluno3@gmail.com", 987654);
		
		studentRepository.saveAll(Arrays.asList(random4,random5,random6));
		
		gradeRepository.deleteAll();
		
		Grade grade1 = new Grade(null, 5.5);
		Grade grade2 = new Grade(null, 8.5);
		Grade grade3 = new Grade(null, 9.5);
		
		gradeRepository.saveAll(Arrays.asList(grade1,grade2,grade3));
		
		subjectRepository.deleteAll();
		
		Subject subject1 = new Subject(null, "Matemática");
		Subject subject2 = new Subject(null, "História");
		Subject subject3 = new Subject(null, "Geografia");
		
		subjectRepository.saveAll(Arrays.asList(subject1,subject2,subject3));
		
		
		
		
		
		
	}

}
