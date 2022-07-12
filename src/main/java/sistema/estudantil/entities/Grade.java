package sistema.estudantil.entities;

public class Grade {
	
	private String id;
	private Double subjectGrade;
	
	public Grade() {
		
	}
	
	public Grade(String id, Double subjectGrade) {
		this.id = id;
		this.subjectGrade = subjectGrade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Double getSubjectGrade() {
		return subjectGrade;
	}
	
	public void setSubjectGrade(Double subjectGrade) {
		this.subjectGrade = subjectGrade;
	}

}
