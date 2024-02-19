package detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Doctor {
	private int Did;
	private String name;
	private String telephone;
	private String email;
	private String qualification;
	private String specialisation;
	public Doctor() {}
	public Doctor(int did, String name, String telephone, String email, String qualification, String specialisation) {
		super();
		Did = did;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.qualification = qualification;
		this.specialisation = specialisation;
	}
	public int getDid() {
		return Did;
	}
	public void setDid(int did) {
		Did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public void makeconnection() {
		String host = "jdbc:mysql://localhost/eliane_ineza_cms";
	    String user = "222014600";
	    String password = "222014600";
	}
	public void insertData() {
		String host = "jdbc:mysql://localhost/eliane_ineza_cms";
	    String user = "222014600";
	    String password = "222014600";
	    String sql = "INSERT INTO doctor (name, telephone,email,qualification,specialisation) VALUES (?, ?, ?, ?, ?)";
	    String sqlQuery="SELECT*From doctor";
	    try {
	    	Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	    	 PreparedStatement qSstm=con.prepareStatement(sqlQuery);
	    	stm.setString(1, name);
	    	stm.setString(2,telephone);
	    	stm.setString(3, email);
	    	stm.setString(4,qualification );
	    	stm.setString(5, specialisation);
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
	public void readwithDid(int did2) {
		String url = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
	    String sql = "SELECT * FROM doctor WHERE Did = ?";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
	    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	preparedStatement.setInt(1, did2);
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	  while (resultSet.next()) {
	    		  this.setDid(resultSet.getInt("DID"));
		             this.setName(resultSet.getString("Name"));
		             this.setTelephone(resultSet.getString("Telephone"));
		             this.setEmail(resultSet.getString("Email"));
		             this.setQualification(resultSet.getString("Qualification"));
		             this.setSpecialisation(resultSet.getString("Specialization"));
	    	  
		       
		             System.out.println("DID: " + getDid() + ", Name: " + getName() + ",Telephone:"+getTelephone()
		             +",Email:"+getEmail()+",Qualification:"+getQualification()+",Specialization:"+getSpecialisation());
	    	  }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void update(int did2) {
		String url = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
	    String sql = "UPDATE doctor SET name = ?, telephone = ?, email = ?,qualification=?,specialisation=? WHERE Did = ?";
	    try {
	    	Connection con = DriverManager.getConnection(url, user, password);
			 PreparedStatement stm = con.prepareStatement(sql);

		        stm.setString(1, this.getName());
		        stm.setString(2, this.getTelephone());
		        stm.setString(3, this.getEmail()); // Assuming there is a column named 'id' for the WHERE clause
		        stm.setString(4, this.getQualification());
		        stm.setString(5, this.getSpecialisation());
		        stm.setInt(6, did2);
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
	public DefaultTableModel populateTable() {
		String url = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
	     String query= "SELECT * FROM doctor";
	     DefaultTableModel tableModel = null;

	     try {
	         Connection con = DriverManager.getConnection(url, user, password);
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
	public void delete(int did2) {
		String url = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
	    String sql = "DELETE FROM doctor WHERE Did = ?";
	    try {
	    	 Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql);
             stm.setInt(1, did2);
             int rowsAffected = stm.executeUpdate();

	         if (rowsAffected > 0) {
	             System.out.println("Data deleted successfully!");
	         } else {
	             System.out.println("Failed to delete data");
	         }} catch (Exception e) {
	 			// TODO: handle exception
	 		}
		
	}
	
	
}
