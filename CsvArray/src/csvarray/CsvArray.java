package csvarray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CsvArray {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
  String csvFileToRead = "/home/sid/Desktop/Sid.csv";
  BufferedReader br = null;
  String line = "";
  String splitBy = ",";
    Connection conn = null;
	Statement stmt = null;
	try {
	  
	  	Class.forName("com.mysql.jdbc.Driver").newInstance();
  	
		String connectionUrl = "jdbc:mysql://localhost:3306/juno";
		String connectionUser = "sid";
		String connectionPassword = "sonny";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		stmt = conn.createStatement();
		
		

   br = new BufferedReader(new FileReader(csvFileToRead));
   ArrayList<Lead> leadArray=new ArrayList<>();  
   
   while ((line = br.readLine()) != null) {

   Lead lead=new Lead();
    String[] data = line.split(splitBy);
    System.out.println("LEAD [ad_id= " + data[0] + " , ad_name="
      + data[1] + " , adset_id=" + data[2] +", adset_name=" + data[3]+  " , campaign_id="
      + data[4] + " , campaign_name=" + data[5] + ", form_id=" + data[6]+ ", is_organic=" + data[7]+
      ", Availability=" + data[8]+", Budget=" + data[9]+ ", Name=" + data[10]+", Location=" + data[11]+
      ", Mobile number=" + data[12]+"]");
    
    
    lead.setAd_id(data[0]);
    lead.setAd_name(data[1]);
    lead.setAdset_id(data[2]);
    lead.setAdset_name(data[3]);
    lead.setCampaign_id(data[4]);
    lead.setCampaign_name(data[5]);
    lead.setForm_id(data[6]);
    lead.setIs_organic(data[7]);
    lead.setAvailability(data[8]);
    lead.setBudget(data[9]);
    lead.setName(data[10]);
    lead.setLocation(data[11]);
    lead.setMobile(data[12]);
    leadArray.add(lead); 
    
    
    

   }
   
   
	  for(int i=0;i<leadArray.size();i++) {
	Lead lead=leadArray.get(i);	 
   String insertStmt = lead.getInsertStatement();		   
      System.out.println(insertStmt);
      
      String sql = lead.getInsertStatement();
      stmt.executeUpdate(sql);

  }
}
  catch (FileNotFoundException e) {
	  
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  } finally {
   if (br != null) {
    try {
     br.close();
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
  }
 }
}