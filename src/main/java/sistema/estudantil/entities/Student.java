package sistema.estudantil.entities;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private Integer registration;
	
	public Student() {
		
	}
	

	public Student(String id, String name, String email, Integer registration) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.registration = registration;
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}
	
}
