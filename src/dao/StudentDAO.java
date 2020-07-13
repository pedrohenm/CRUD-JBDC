package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Situation;
import classes.Student;
import connection.ConnectionFactory;

public class StudentDAO {
	public static void save(Student student) {
		String sql = "INSERT INTO Students (student_name, gener, situacao_id, student_login) VALUES (?, ?, ?, ?)";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, student.getStudentName());
			ps.setString(2, String.valueOf(student.getStudentGender()));
			ps.setInt(3, student.getSituationId().getSituationId());
			ps.setString(4, student.getStudentLogin());
			ps.executeUpdate();
			System.out.println("\nO registro foi inserido com sucesso\n");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Student student) {
		if(student == null) {
			System.out.println("\nNão foi possivel excluir o registro\n");
			return;
		}
		String sql = "DELETE FROM Students WHERE student_id=?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, student.getStudentId());
			ps.executeUpdate();
			System.out.println("O registro foi excluido com sucesso");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Student student) {
		if(student == null) {
			System.out.println("\nNão foi possivel atualizar o registro\n");
			return;
		}
		String sql = "UPDATE Students SET student_name= ?, gener= ?, situacao_id= ?, student_login= ? WHERE student_id=?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, student.getStudentName());
			ps.setString(2, String.valueOf(student.getStudentGender()));
			ps.setInt(3, student.getSituationId().getSituationId());
			ps.setString(4, student.getStudentLogin());
			ps.setInt(5, student.getStudentId());
			ps.executeUpdate();
			System.out.println("\nO registro foi atualizado com sucesso\n");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Student> selectAll() {
		String sql = "SELECT student_id, student_name, gener, student_login, situacao_id FROM Students";
		List<Student> studentList = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				Situation s = SituationDAO.searchById(rs.getInt("situacao_id"));
				studentList.add(new Student(rs.getInt("student_id"), rs.getString("student_name"), rs.getString("gener").charAt(0), rs.getString("student_login"), s));
			}
			return studentList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Student searchById(Integer id) {
		String sql = "SELECT student_id, student_name, gener, student_login, situacao_id FROM Students WHERE student_id=?";
		Student student = null;
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Situation s = SituationDAO.searchById(rs.getInt("situacao_id"));
				student = new Student(rs.getInt("student_id"), rs.getString("student_name"), rs.getString("gener").charAt(0), rs.getString("student_login"), s);
			}
			ConnectionFactory.close(conn, ps, rs);
			return student;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}