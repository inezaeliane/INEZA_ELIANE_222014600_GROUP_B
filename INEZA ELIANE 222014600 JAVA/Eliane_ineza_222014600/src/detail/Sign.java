package detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Sign {
    private String fname;
    private String lname;
    private String gender;
    private String phone;
    private String martialStatus;
    private String DoB; 
    private String email;
    private String setpassword;
    private String confirmpassword;
    public Sign() {}
	public Sign(String fname, String lname, String gender, String phone, String martialStatus, String doB, String email,
			String setpassword, String confirmpassword) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.phone = phone;
		this.martialStatus = martialStatus;
		DoB = doB;
		this.email = email;
		this.setpassword = setpassword;
		this.confirmpassword = confirmpassword;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMartialStatus() {
		return martialStatus;
	}
	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}
	public String getDoB() {
		return DoB;
	}
	public void setDoB(String doB) {
		DoB = doB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSetpassword() {
		return setpassword;
	}
	public void setSetpassword(String setpassword) {
		this.setpassword = setpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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
			    String sql = "INSERT INTO account (Fname, Lname,Gender,Phone,Martial_status,Dob,Email ,SetPassword ,ConfirmPassword) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
		try {
			Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	    	stm.setString(1, fname);
	    	stm.setString(2,lname);
	    	stm.setString(3, gender);
	    	stm.setString(4, phone);
	    	stm.setString(5, martialStatus);
	    	stm.setString(6, DoB);
	    	stm.setString(7, email);
	    	stm.setString(8, setpassword);
	    	stm.setString(9, confirmpassword);
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
	public void login() {
		String host = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
		 String user = "222014600";
		    String password = "222014600";
	    String sql = "INSERT INTO account where Phone=?,Email=? ,SetPassword=?";
		try {
			Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	    	 stm.setString(1, phone);
	    	 stm.setString(2, email);
	    	 stm.setString(3, setpassword);
	    	 ResultSet rs = stm.executeQuery();
	    		if(rs.next()) {
	    			System.out.println("Data inserted successfully!");
	                JOptionPane.showMessageDialog(null, "Login successfully!","After login",JOptionPane.INFORMATION_MESSAGE);
	    		} else {
	    			JOptionPane.showMessageDialog(null, "Incorect Email and password!","After login",JOptionPane.INFORMATION_MESSAGE);
	    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
