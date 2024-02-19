package detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Appointment {
	private int Aid;
	private String issueDate;
	private String returnDate;
	private String Pid;
	private String Cid;
	private String Did;
	
	public Appointment() {
		
	}
	public Appointment(int aid,  String issueDate, String returnDate,  String pid,
			String cid, String did) {
		super();
		Aid = aid;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		Pid = pid;
		Cid = cid;
		Did = did;
	}
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}

	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getDid() {
		return Did;
	}
	public void setDid(String did) {
		Did = did;
	}
	public void makeconnection() {
		String host = "jdbc:mysql://localhost/eliane_ineza_cms";
	    String user = "222014600";
	    String password = "222014600";
	}
	public void insertData() {
		String host = "jdbc:mysql://localhost/eliane_ineza_cms";
	    String user = "222014600";
	    String password = "";
	    String sql = "INSERT INTO appointment (issueDate,returnDate,Pid,Cid,Did) VALUES ( ?,?,?,?,?)";
	    try {
	    	Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	   
	    	stm.setString(1,this.issueDate);
	    	stm.setString(2, this.returnDate);
	    	stm.setString(3, this.Pid);
	    	stm.setString(4, this.Cid);
	    	stm.setString(5, this.Did);
	    	
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
	public void readwithAid(int aid2) {
		String url = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
	    String user = "222014600";
	    String password = "222014600";
	    String sql = "SELECT * FROM appointment WHERE Aid = ?";
		try {

			Connection connection = DriverManager.getConnection(url, user, password);
	    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	preparedStatement.setInt(1, aid2);
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	  while (resultSet.next()) {
	    		  this.setAid(resultSet.getInt("AID"));
		             this.setIssueDate(resultSet.getString("IssueDate"));
		             this.setReturnDate(resultSet.getString("ReturnDate"));
		             this.setPid(resultSet.getString("Pid"));
		             this.setCid(resultSet.getString("Cid"));
		             this.setDid(resultSet.getString("Did"));
	    	  
		       
		             System.out.println("AID: " + getAid() + ", IssueDate: " + getIssueDate() + ", ReturnDate: " + getReturnDate()+",Pid:"+getPid()
		             +",Cid:"+getCid()+",Did:"+getDid());
	    	  }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void update(int aid2) {
		String url = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
	    String user = "222014600";
	    String password = "";
	    String sql =  "UPDATE appointment SET issueDate = ?,returnDate=?, 	Pid = ?, Cid = ?,Did=? WHERE Aid = ?";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			 PreparedStatement stm = con.prepareStatement(sql);
			    stm.setString(1,this.issueDate);
		    	stm.setString(2, this.returnDate);
		    	stm.setString(3, this.Pid);
		    	stm.setString(4, this.Cid);
		    	stm.setString(5, this.Did);
		    	stm.setInt(6, aid2);
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
	public void delete(int aid2) {
		String url = "jdbc:mysql://localhost/eliane_ineza_cms";
	    String user = "222014600";
	    String password = "222014600";
	    String sql = "DELETE FROM appointment WHERE Aid = ?";
	    try {
	    	 Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql);
             stm.setInt(1, aid2);
             int rowsAffected = stm.executeUpdate();

	         if (rowsAffected > 0) {
	             System.out.println("Data deleted successfully!");
	         } else {
	             System.out.println("Failed to delete data");
	         }} catch (Exception e) {
		 			// TODO: handle exception
		 		}
	}
	public DefaultTableModel populateTable() {
		 String host = "jdbc:mysql://localhost/eliane_ineza_cms";
	     String user = "222014600";
	     String password = "222014600";
	     String query= "SELECT * FROM appointment";
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
