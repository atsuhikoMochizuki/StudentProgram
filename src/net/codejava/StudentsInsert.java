package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class StudentsInsert {
	
	public static void main(String[] args){
		// init db
		String dbURL = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "root";

		Connection conn = null;
		String sql = null;
		
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the number of students: ");
			int numberOfStudents = scanner.nextInt();
			int countInsertion = 0;
			int countInformationToDisplay = 1;

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			while(countInsertion < numberOfStudents){
				System.out.println("Enter information for student #"+countInformationToDisplay + "\t");
				System.out.println("");
				System.out.println("\tName: ");
				String name = reader.readLine();
				System.out.println("\tEmail:");
				String email = reader.readLine();
				System.out.println("\tUniversity: ");
				String university = reader.readLine();

				conn = DriverManager.getConnection(dbURL, username,password);
				//insert data to student table
				sql = "insert into Student(name,email,university) values(?,?,?);";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, name);
				statement.setString(2,email);
				statement.setString(3,university);

				int rowInserted = statement.executeUpdate();

				if(rowInserted>0){
					++countInsertion;
					++countInformationToDisplay;
				}
				System.out.println(""+countInsertion+" students saved to database");
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		finally{
			try {
				if (conn != null){
					conn.close();
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
