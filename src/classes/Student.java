package classes;

public class Student {
	private int StudentId;
	private String StudentName;
	private char StudentGender;
	private String StudentLogin;
	private Situation SituationId;
	
	public Student() {
	}
	
	public Student(int studentId, String studentName, char studentGender, String studentLogin, Situation situationId) {
		StudentId = studentId;
		StudentName = studentName;
		StudentGender = studentGender;
		StudentLogin = studentLogin;
		SituationId = situationId;
	}

	public int getStudentId() {
		return StudentId;
	}


	public void setStudentId(int studentId) {
		StudentId = studentId;
	}


	public String getStudentName() {
		return StudentName;
	}


	public void setStudentName(String studentName) {
		StudentName = studentName;
	}


	public char getStudentGender() {
		return StudentGender;
	}


	public void setStudentGender(char studentGender) {
		StudentGender = studentGender;
	}


	public String getStudentLogin() {
		return StudentLogin;
	}


	public void setStudentLogin(String studentLogin) {
		StudentLogin = studentLogin;
	}

	public Situation getSituationId() {
		return SituationId;
	}

	public void setSituationId(Situation situationId) {
		SituationId = situationId;
	}
	
	
}
