package org.alvas.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class service {

	private static final String url = "jdbc:postgresql://localhost:5432/HOSPITAL_M_S?user=postgres&password=root"; // connection URL

	public static void saveData() {

		// Load the driver
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(url);

			String sql = "INSERT INTO doctor (id, name, salary, specialization, age, gender) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);
			System.out.println("ENTER ID :");
			int id = sc.nextInt();
			System.out.println("ENTER NAME :");
			String name = sc.next();
			System.out.println("ENTER SALARY :");
			int salary = sc.nextInt();
			System.out.println("ENTER SPECIALIZATION :");
			String spec = sc.next();
			System.out.println("ENTER AGE :");
			int age = sc.nextInt();
			System.out.println("ENTER GENDER :");
			String gender = sc.next();

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, salary);
			ps.setString(4, spec);
			ps.setInt(5, age);
			ps.setString(6, gender);

			ps.executeUpdate();

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// New method for updating data
	public static void updateData() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);

			String sql = "UPDATE doctor SET salary = ? WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);
			System.out.println("ENTER DOCTOR ID TO UPDATE SALARY:");
			int id = sc.nextInt();
			System.out.println("ENTER NEW SALARY:");
			int newSalary = sc.nextInt();

			ps.setInt(1, newSalary);
			ps.setInt(2, id);

			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Salary updated successfully for doctor with ID: " + id);
			} else {
				System.out.println("No doctor found with ID: " + id);
			}

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// delete method
	public static void deleteData() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);

			String sql = "DELETE FROM doctor WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);
			System.out.println("ENTER DOCTOR ID TO DELETE:");
			int id = sc.nextInt();

			ps.setInt(1, id);

			int rowsDeleted = ps.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Doctor deleted successfully with ID: " + id);
			} else {
				System.out.println("No doctor found with ID: " + id);
			}

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Method for displaying data
		public static void displayData() {
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection(url);

				String sql = "SELECT * FROM doctor";

				PreparedStatement ps = con.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int salary = rs.getInt("salary");
					String specialization = rs.getString("specialization");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");

					System.out.println("ID : "+id + " , " +"NAME : "+ name + " , " +"SALARY : "+ salary + " , " +" SPECIALIZATION : "+ specialization + " , " +"AGE : "+ age + " , " +" GENDER : "+ gender);
				}

				con.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}