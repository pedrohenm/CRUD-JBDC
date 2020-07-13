package classes;

public class Situation {
	
	private int SituationId;
	private String SituationName;
	private String StudentLogin;
	
	public Situation() {
	}
	
	public Situation(int situationId, String situationName, String studentLogin) {
		SituationId = situationId;
		SituationName = situationName;
		StudentLogin = studentLogin;
	}
	public int getSituationId() {
		return SituationId;
	}
	public void setSituationId(int situationId) {
		SituationId = situationId;
	}
	public String getSituationName() {
		return SituationName;
	}
	public void setSituatioName(String situatioName) {
		SituationName = situatioName;
	}
	public String getStudentLogin() {
		return StudentLogin;
	}
	public void setStudentLogin(String studentLogin) {
		StudentLogin = studentLogin;
	}
	
}
