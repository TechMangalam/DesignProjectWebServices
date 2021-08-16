package com.bitaam.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StudentRepository {
	
	Connection con = null;
	
	public StudentRepository() {
		
		String url = "jdbc:mysql://localhost:3306/students";
		String username = "root";
		String pass = "Mangalam06-";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,pass);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error in connection"+e.getMessage());
		}
	}
	
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		String sql = "select * from student";
		
		try {
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				Student s = new Student();
				s.setName(result.getString(1));
				s.setId(String.valueOf(result.getInt(2)));
				s.setBranch(result.getString(3));
				s.setBatch(String.valueOf(result.getInt(4)));
				
				students.add(s);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return students;
	}
	
	public Student getStudent(String id) {
		
		String sql = "select * from student where id="+id;
		Student s = new Student();
		
		try {
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			if(result.next()) {
				
				s.setName(result.getString(1));
				s.setId(String.valueOf(result.getInt(2)));
				s.setBranch(result.getString(3));
				s.setBatch(String.valueOf(result.getInt(4)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return s;
		
	}
	
	public void createStudent(Student s) {
		
		String sql = "insert into student values (?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,s.getName());
			st.setInt(2, Integer.parseInt(s.getId()));
			st.setString(3, s.getBranch());
			st.setInt(4, Integer.parseInt(s.getBatch()));
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public String updateStudent(String id) {
		String sql = "delete from student where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(id));
			st.executeUpdate();
			
			return id;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getLocalizedMessage();
		}
	}
	
	

}
