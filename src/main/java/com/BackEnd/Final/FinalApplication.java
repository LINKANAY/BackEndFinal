package com.BackEnd.Final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

import static com.BackEnd.Final.models.ERole.ROLE_ADMIN;

@SpringBootApplication
public class FinalApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(FinalApplication.class, args);
		// Conectar a la base de datos
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://by3i9saxaffj2io0di3o-mysql.services.clever-cloud.com:3306/by3i9saxaffj2io0di3o", "uqwswxcbivy9ofsy", "QDQNMwn6K124N1I3ekXK");
			stmt = con.createStatement();
			String sql = "INSERT INTO roles (id, name) VALUES (null, 'ROLE_ADMIN')";
			String sql2 = "INSERT INTO roles (id, name) VALUES (null, 'ROLE_USER')";
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			System.out.println("Datos insertados con éxito");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}


}
