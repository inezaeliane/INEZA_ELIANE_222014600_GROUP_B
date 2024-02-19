package detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Patient {
	private int Pid;
	private String name;
	private String gender;
	private String telephone;
	private String email;
	private String address;
	public Patient() {}
	public Patient(int pid, String name, String gender, String telephone, String email, String address) {
		Pid = pid;
		this.name = name;
		this.gender = gender;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
	}
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void makeconnection() {
		String host = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
	}
	public void insertData() {
		String host = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
	    String sql = "INSERT INTO patient (name, gender,telephone,email,address) VALUES (?, ?, ?, ?, ?)";
		try {
			Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	    	stm.setString(1, name);
	    	stm.setString(2,gender);
	    	stm.setString(3, telephone);
	    	stm.setString(4, email);
	    	stm.setString(5, address);
	    	int rowsAffected = stm.executeUpdate();
	         if (rowsAffected > 0) {
	        	 System.out.println("data inserted succeccful");
	        	 JOptionPane.showMessageDialog(null, "data inserted successful","After insert",JOptionPane.INFORMATION_MESSAGE);
	         }
	        	 else {
	        		 System.out.println("Failed to insert data!!!");
	                 JOptionPane.showMessageDialog(null, "Failed to insert data!!!","After insert",JOptionPane.ERROR_MESSAGE);
	                 }
					
				
	         
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void readwithPid(int pid2) {
		String url = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
			    String sql = "SELECT * FROM patient WHERE Pid = ?";
		try {

			Connection connection = DriverManager.getConnection(url, user, password);
	    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	preparedStatement.setInt(1, pid2);
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	  while (resultSet.next()) {
	    		  this.setPid(resultSet.getInt("PID"));
		             this.setName(resultSet.getString("Name"));
		             this.setGender(resultSet.getString("Gender"));
		             this.setTelephone(resultSet.getString("Telephone"));
		             this.setEmail(resultSet.getString("Email"));
		             this.setAddress(resultSet.getString("Address"));
	    	  
		       
		             System.out.println("PID: " + getPid() + ", Name: " + getName() + ", Gender: " + getGender()+",Telephone:"+getTelephone()
		             +",Email:"+getEmail()+",Address:"+getAddress());
	    	  }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void update(int pid2) {
		String url = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
	    String sql =  "UPDATE patient SET name = ?,gender=?, telephone = ?, email = ?,address=? WHERE Pid = ?";
	    try {
	    	Connection con = DriverManager.getConnection(url, user, password);
			 PreparedStatement stm = con.prepareStatement(sql);

		        stm.setString(1, this.getName());
		        stm.setString(2, this.getGender());
		        stm.setString(3, this.getTelephone()); // Assuming there is a column named 'id' for the WHERE clause
		        stm.setString(4, this.getEmail());
		        stm.setString(5, this.getAddress());
		        stm.setInt(6, pid2);
		        int rowsAffected = stm.executeUpdate();

	            
	            if (rowsAffected > 0) {
	                System.out.println("Data updated successfully!");
	            } else {
	                System.out.println("Failed to update data. No matching record found.");
	            }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void delete(int pid2) {
		String url = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
	    String sql = "DELETE FROM patient WHERE Pid = ?";
	    try {
	    	 Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql);
             stm.setInt(1, pid2);
             int rowsAffected = stm.executeUpdate();

	         if (rowsAffected > 0) {
	             System.out.println("Data deleted successfully!");
	         } else {
	             System.out.println("Failed to delete data");
	         }} catch (Exception e) {
	 			// TODO: handle exception
	 		}
		
	}
	public static DefaultTableModel populateTable() {
		String host = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
	     String query= "SELECT * FROM patient";
	     DefaultTableModel tableModel = null;

	     try {
	         Connection con = DriverManager.getConnection(host, user, password);
	         PreparedStatement stm = con.prepareStatement(query);
	         ResultSet resultSet = stm.executeQuery();

	         int columnCount = resultSet.getMetaData().getColumnCount();
	         Vector<String> columnNames = new Vector<>();
	         for (int i = 1; i <= columnCount; i++) {
	             columnNames.add(resultSet.getMetaData().getColumnName(i));
	         }

	         Vector<Vector<Object>> data = new Vector<>();
	         while (resultSet.next()) {
	             Vector<Object> row = new Vector<>();
	             for (int i = 1; i <= columnCount; i++) {
	                 row.add(resultSet.getObject(i));
	             }
	             data.add(row);
	         }

	         tableModel = new DefaultTableModel(data, columnNames);
	         con.close(); // Close the connection when done to release resources
	     } catch (Exception e) {
	         e.printStackTrace(); // Print the exception details for debugging purposes
	     }
	     return tableModel;
	 }
		
	}
	
	
