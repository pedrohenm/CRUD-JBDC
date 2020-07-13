package classes;

public class Course {
	
	private Integer CourseId;
	private String CourseName;
	private String StudentLogin;
	
	public Course() {
		
	}
	
	public Course(Integer courseId, String courseName, String studentLogin) {
		super();
		CourseId = courseId;
		CourseName = courseName;
		StudentLogin = studentLogin;
	}
	public Integer getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getStudentLogin() {
		return StudentLogin;
	}
	public void setStudentLogin(String studentLogin) {
		StudentLogin = studentLogin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CourseId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (CourseId != other.CourseId)
			return false;
		return true;
	}
}
