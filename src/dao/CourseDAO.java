package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;

import classes.Course;

public class CourseDAO {
	public static void save(Course course) {
		String sql = "INSERT INTO Courses (course_name, student_login) VALUES (?, ?)";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, course.getCourseName());
			ps.setString(2, course.getStudentLogin());
			ps.executeUpdate();
			System.out.println("\nO registro foi inserido com sucesso\n");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Course course) {
		if(course == null) {
			System.out.println("\nNão foi possivel excluir o registro\n");
			return;
		}
		String sql = "DELETE FROM Courses WHERE course_id=?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, course.getCourseId());
			ps.executeUpdate();
			System.out.println("O registro foi excluido com sucesso");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Course course) {
		if(course == null) {
			System.out.println("\nNão foi possivel atualizar o registro\n");
			return;
		}
		String sql = "UPDATE Courses SET course_name= ?, student_login= ? WHERE course_id=?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, course.getCourseName());
			ps.setString(2, course.getStudentLogin());
			ps.setInt(3, course.getCourseId());
			ps.executeUpdate();
			System.out.println("\nO registro foi atualizado com sucesso\n");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Course> selectAll() {
		String sql = "SELECT course_id, course_name, student_login FROM Courses";
		List<Course> courseList = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				courseList.add(new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("student_login")));
			}
			return courseList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Course searchById(Integer id) {
		String sql = "SELECT course_id, course_name, student_login FROM Courses WHERE course_id=?";
		Course course = null;
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				course = new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("student_login"));
			}
			ConnectionFactory.close(conn, ps, rs);
			return course;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
