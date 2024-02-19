package detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Clinic {
	private int Cid;
	private String name;
	private String location;
	private String type;
	public Clinic() {}
	public Clinic(int cid, String name, String location, String type) {
		Cid = cid;
		this.name = name;
		this.location = location;
		this.type = type;
	}
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void makeconnection() {
		String host = "jdbc:mysql://localhost/clinic_management_system";
	    String user = "root";
	    String password = "";
	}
	public void insertData() {
		String host = "jdbc:mysql://localhost/clinic_management_system";
	    String user = "root";
	    String password = "";
	    String sql = "INSERT INTO clinic (name,location,type) VALUES (?, ?, ?)";
	    try {
	    	Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	    	stm.setString(1, name);
	    	stm.setString(2,location);
	    	stm.setString(3, type);
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
	public void readwithCid(int cid2) {
		String url = "jdbc:mysql://localhost:3306/clinic_management_system";
	    String user = "root";
	    String password = "";
	    String sql = "SELECT * FROM clinic WHERE Cid = ?";
	    try {
	    	Connection connection = DriverManager.getConnection(url, user, password);
	    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	preparedStatement.setInt(1, cid2);
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	  while (resultSet.next()) {
	    		  this.setCid(resultSet.getInt("CID"));
		             this.setName(resultSet.getString("Name"));
		             this.setLocation(resultSet.getString("Location"));
		             this.setType(resultSet.getString("Type"));
		       
		             System.out.println("CID: " + getCid() + ", Name: " + getName() + ",Location:"+getLocation()+",Type:"+getType());
	    	  }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void update(int cid2) {
		String url = "jdbc:mysql://localhost:3306/clinic_management_system";
	    String user = "root";
	    String password = "";
	    String sql = "UPDATE clinic SET name = ?,location=?,type=? WHERE Cid = ?";
	    try {
	    	Connection con = DriverManager.getConnection(url, user, password);
			 PreparedStatement stm = con.prepareStatement(sql);

		        stm.setString(1, this.getName());
		        stm.setString(2, this.getLocation());
		        stm.setString(3, this.getType()); // Assuming there is a column named 'id' for the WHERE clause
		        stm.setInt(4, cid2);
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
		 String host = "jdbc:mysql://localhost/clinic_management_system";
	     String user = "root";
	     String password = "";
	     String query= "SELECT * FROM clinic";
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
	public void delete(int cid2) {
		String url = "jdbc:mysql://localhost/clinic_management_system";
	    String user = "root";
	    String password = "";
	    String sql = "DELETE FROM clinic WHERE Cid = ?";
	    try {
	    	 Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql);
             stm.setInt(1, cid2);
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
