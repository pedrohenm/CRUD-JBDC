package classes;

public class Class {
	
	private int ClassId;
	private Student StudentId;
	private Course CourseId;
	private String StudentLogin;
	
	public Class() {
		
	}
	
	

	public Class(int classId, Student studentId, Course courseId, String studentLogin) {
		super();
		ClassId = classId;
		StudentId = studentId;
		CourseId = courseId;
		StudentLogin = studentLogin;
	}



	public int getClassId() {
		return ClassId;
	}



	public void setClassId(int classId) {
		ClassId = classId;
	}



	public Student getStudentId() {
		return StudentId;
	}



	public void setStudentId(Student studentId) {
		StudentId = studentId;
	}



	public Course getCourseId() {
		return CourseId;
	}



	public void setCourseId(Course courseId) {
		CourseId = courseId;
	}



	public String getStudentLogin() {
		return StudentLogin;
	}



	public void setStudentLogin(String studentLogin) {
		StudentLogin = studentLogin;
	}


}
