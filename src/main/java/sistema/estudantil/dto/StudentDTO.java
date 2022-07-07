package sistema.estudantil.dto;

import java.io.Serializable;

import sistema.estudantil.entities.Student;

public class StudentDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private Integer registration;
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(Student obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		registration = obj.getRegistration();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getRegistration() {
		return registration;
	}
	
	public void setRegistration(Integer registration) {
		this.registration = registration;
	}

}
