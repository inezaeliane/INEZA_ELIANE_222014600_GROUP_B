package detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Service {
public int Sid;
public String service_name;
public int Service_cost;
public String Pid;
public String Cid;
public String Did;
public String Aid;
public Service(int sid, String service_name, int service_cost, String pid, String cid, String did, String aid) {
	super();
	Sid = sid;
	this.service_name = service_name;
	Service_cost = service_cost;
	Pid = pid;
	Cid = cid;
	Did = did;
	Aid = aid;
}
public int getSid() {
	return Sid;
}
public void setSid(int sid) {
	Sid = sid;
}
public String getService_name() {
	return service_name;
}
public void setService_name(String service_name) {
	this.service_name = service_name;
}
public int getService_cost() {
	return Service_cost;
}
public void setService_cost(int service_cost) {
	Service_cost = service_cost;
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
public String getAid() {
	return Aid;
}
public void setAid(String aid) {
	Aid = aid;
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
	    String sql = "INSERT INTO service (service_name,service_cost,Pid,Cid,Did,Aid) VALUES ( ?,?,?,?,?,?)";
	try {
		Connection con = DriverManager.getConnection(host, user, password);
   	 PreparedStatement stm= con.prepareStatement(sql);
  
   	stm.setString(1,this.service_name);
   	stm.setInt(2, this.Service_cost);
   	stm.setString(3, this.Pid);
   	stm.setString(4, this.Cid);
   	stm.setString(5, this.Did);
   	stm.setString(6, this.Aid);
   	
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
public void viewData() {
	String host = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
	 String user = "222014600";
	    String password = "222014600";
    String sql = "SELECT * FROM service";
    try {
    	Connection con = DriverManager.getConnection(host, user, password);
      	 PreparedStatement stm= con.prepareStatement(sql);
      	ResultSet resultSet = stm.executeQuery();
      	while (resultSet.next()) {
      		int Sid = resultSet.getInt("Sid");
			String Servicename = resultSet.getString("Service Name");
			String Servicecost = resultSet.getString("Service Cost");
			String Pid = resultSet.getString("Patient");
			String Cid = resultSet.getString("Clinic");
			String Did = resultSet.getString("Doctor");
			String Aid=resultSet.getString("Appointment");
			
			System.out.println("Sid: " + Sid + ",Service Name : " + Servicename 
					+ ",Service Cost : " + Servicecost+" ,Patient : "+Pid
					+",Clinic: "+Cid+",Doctor:  "+Did+",Appointment:"+Aid);
      	}
    	
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
public DefaultTableModel populateTable() {
	String host = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
	 String user = "222014600";
	    String password = "222014600";
     String query= "SELECT * FROM service";
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
public void update(int sid2) {
	String host = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
	 String user = "222014600";
	    String password = "222014600";
	String sql="UPDATE service set service_name=?, 	service_cost=?, Pid=?, Cid=?, Did=?,Aid=? where Sid=?";
	try {
		Connection con = DriverManager.getConnection(host, user, password);
		PreparedStatement stm = con.prepareStatement(sql);

        stm.setString(1, this.service_name);
        stm.setInt(2,this.Service_cost );
        stm.setString(3, this.Pid);
        stm.setString(4, this.Cid);
        stm.setString(5, this.Did);
        stm.setString(6, this.Aid);
        stm.setInt(7, sid2);
        
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
public void delete(int sid2) {
	String url = "jdbc:mysql://localhost:3306/eliane_ineza_cms";
	 String user = "222014600";
	    String password = "222014600";
    String sql = "DELETE FROM service WHERE Sid = ?";
    try {
    	 Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement stm = con.prepareStatement(sql);
         stm.setInt(1, sid2);
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




	

