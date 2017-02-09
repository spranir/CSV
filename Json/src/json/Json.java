package json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Json {

    public static void main(String[] args) {

    	String csvFileToRead = "/home/sid/Desktop/Sid.csv";
    	  BufferedReader br = null;
    	  String line = "";
    	  String splitBy = ",";
          FileWriter fileWriter;


        try {

        	 br = new BufferedReader(new FileReader(csvFileToRead));

        	 ArrayList<Lead> leadArray=new ArrayList<>();
             File file=new File("/home/sid/Lead.json");
             file.createNewFile();
             fileWriter = new FileWriter(file);

        	   while ((line = br.readLine()) != null) {

        		   Lead lead=new Lead();

        		   String[] data = line.split(splitBy);

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

        		   for(int i=0;i<leadArray.size();i++){
        			   Lead lead=leadArray.get(i);
        			   String juno=lead.getInsertStatement();

                   		System.out.println("Writing JSON object to file");
                   		System.out.println("-----------------------");
                   		System.out.print(juno);
                        fileWriter.write(juno);  
                		fileWriter.flush();
                		
                   	}
        		   
        		   fileWriter.close();
        		   

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}