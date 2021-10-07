package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoteDAO {

	private Connection con;

	public NoteDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/note?characterEncoding=utf-8", "root", "root");
	}

	// เมธอดปิดการเชื่อมต่อฐานข้อมูล
	public void closeConnection() throws SQLException {
		con.close();
	}

	public ArrayList<Note> findAll() throws SQLException {

		// ประกาศอาร์เรย์สำหรับเก็บ javabeans
		ArrayList<Note> result = new ArrayList<Note>();
		
		// เตรียมคำสั่ง SQL
		PreparedStatement pStatement = con.prepareStatement("SELECT * FROM note");

		// ส่งคำสั่ง SQL ไปยังฐานข้อมูล
		ResultSet rs = pStatement.executeQuery();

		while (rs.next()) {
			Note note = new Note();
			note.setId(rs.getString("id"));
			note.setDetail(rs.getString("detail"));
			result.add(note);
		}
		return result; // ส่งอาร์เรย์กลับ
	}
	public static void main(String[] args) {
		try {
			NoteDAO dao = new NoteDAO();
			ArrayList<Note> list = dao.findAll();
			for(Note n: list) {
				System.out.println(n.getDetail());				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
