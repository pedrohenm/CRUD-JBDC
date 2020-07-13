package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Class;
import classes.Course;
import classes.Student;
import connection.ConnectionFactory;

public class ClassDAO {
	public static void save(Class classe) {
		String sql = "INSERT INTO Classes (student_id, course_id, student_login) VALUES (?, ?, ?)";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, classe.getStudentId().getStudentId());
			ps.setInt(2, classe.getCourseId().getCourseId());
			ps.setString(3, classe.getStudentLogin());
			ps.executeUpdate();
			System.out.println("\nO registro foi inserido com sucesso\n");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Class classe) {
		if(classe == null) {
			System.out.println("\nNão foi possivel excluir o registro\n");
			return;
		}
		String sql = "DELETE FROM Classes WHERE class_id=?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, classe.getClassId());
			ps.executeUpdate();
			System.out.println("O registro foi excluido com sucesso");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Class classe) {
		if(classe == null) {
			System.out.println("\nNão foi possivel atualizar o registro\n");
			return;
		}
		String sql = "UPDATE Classes SET student_id= ?, course_id= ?, student_login=?, WHERE class_id=?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, classe.getStudentId().getStudentId());
			ps.setInt(2, classe.getCourseId().getCourseId());
			ps.setString(3, classe.getStudentLogin());
			ps.setInt(4, classe.getClassId());
			ps.executeUpdate();
			System.out.println("\nO registro foi atualizado com sucesso\n");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Class> selectAll() {
		String sql = "SELECT class_id, student_id, course_id, student_login FROM Classes";
		List<Class> classList = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				Course c = CourseDAO.searchById(rs.getInt("course_id"));
				Student s = StudentDAO.searchById(rs.getInt("student_id"));
				classList.add(new Class(rs.getInt("class_id"), s, c, rs.getString("student_login")));
			}
			return classList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
