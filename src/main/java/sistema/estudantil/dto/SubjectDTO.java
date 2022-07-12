package sistema.estudantil.dto;

import java.io.Serializable;

import sistema.estudantil.entities.Subject;

public class SubjectDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public SubjectDTO() {
		
	}
	
	public SubjectDTO(Subject obj) {
		id = obj.getId();
		name = obj.getName();
		
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

}
