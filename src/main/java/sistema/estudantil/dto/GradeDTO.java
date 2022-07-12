package sistema.estudantil.dto;

import java.io.Serializable;

import sistema.estudantil.entities.Grade;

public class GradeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Double subjectGrade;
	
	public GradeDTO() {
		
	}
	
	public GradeDTO(Grade obj) {
		id = obj.getId();
		subjectGrade = obj.getSubjectGrade();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getSubjetctGrade() {
		return subjectGrade;
	}

	public void setGrade(Double subjectgrade) {
		this.subjectGrade = subjectgrade;
	}

}
