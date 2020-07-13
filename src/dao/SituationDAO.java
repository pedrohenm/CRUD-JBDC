package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Situation;
import connection.ConnectionFactory;

public class SituationDAO {
	public static void save(Situation situation) {
		String sql = "INSERT INTO Situations (situacao, student_login) VALUES (?, ?)";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, situation.getSituationName());
			ps.setString(2, situation.getStudentLogin());
			ps.executeUpdate();
			System.out.println("\nO registro foi inserido com sucesso\n");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Situation situation) {
		if(situation == null) {
			System.out.println("\nNão foi possivel excluir o registro\n");
			return;
		}
		String sql = "DELETE FROM Situations WHERE situacao_id=?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, situation.getSituationId());
			ps.executeUpdate();
			System.out.println("O registro foi excluido com sucesso");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Situation situation) {
		if(situation == null) {
			System.out.println("\nNão foi possivel atualizar o registro\n");
			return;
		}
		String sql = "UPDATE Situations SET situacao= ?, student_login= ? WHERE situacao_id=?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, situation.getSituationName());
			ps.setString(2, situation.getStudentLogin());
			ps.setInt(3, situation.getSituationId());
			ps.executeUpdate();
			System.out.println("\nO registro foi atualizado com sucesso\n");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Situation> selectAll() {
		String sql = "SELECT situacao_id, situacao, student_login FROM Situations";
		List<Situation> studentList = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				studentList.add(new Situation(rs.getInt("situacao_id"), rs.getString("situacao"), rs.getString("student_login")));
			}
			return studentList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Situation searchById(Integer id) {
		String sql = "SELECT situacao_id, situacao, student_login FROM Situations WHERE situacao_id=?";
		Situation situation= null;
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				situation = new Situation(rs.getInt("situacao_id"), rs.getString("situacao"), rs.getString("student_login"));
			}
			ConnectionFactory.close(conn, ps, rs);
			return situation;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}