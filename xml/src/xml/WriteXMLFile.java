package xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {

	private static BufferedReader br;

	public static void main(String argv[]) throws DOMException, IOException, TransformerFactoryConfigurationError {
		
		String csvFileToRead = "/home/sid/Desktop/Sid.csv";
		  
		  String line = "";
		  String splitBy = ",";

	  try {
		
		  
		br = new BufferedReader(new FileReader(csvFileToRead));  
		

		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		ArrayList<Lead> ldArray=new ArrayList<>();
		
		while ((line = br.readLine()) != null) {
			
			

			  Lead ld=new Lead();
			    String[] data = line.split(splitBy);
			    			    
			    ld.setAd_id(data[0]);
			    ld.setAd_name(data[1]);
			    ld.setAdset_id(data[2]);
			    ld.setAdset_name(data[3]);
			    ld.setCampaign_id(data[4]);
			    ld.setCampaign_name(data[5]);
			    ld.setForm_id(data[6]);
			    ld.setIs_organic(data[7]);
			    ld.setAvailability(data[8]);
			    ld.setBudget(data[9]);
			    ld.setName(data[10]);
			    ld.setLocation(data[11]);
			    ld.setMobile(data[12]);
			    
			    ldArray.add(ld); 
		
			    
			    // root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("ld");
		doc.appendChild(rootElement);
		for(int i=0;i<ldArray.size();i++) {
		// details elements
		Element details = doc.createElement("Details");
		rootElement.appendChild(details);
		
		
				
			
		Element ad_id = doc.createElement("ad_id");
		ad_id.appendChild(doc.createTextNode(data[0]));
		details.appendChild(ad_id);
		
		Element ad_name = doc.createElement("ad_name");
		ad_name.appendChild(doc.createTextNode(data[1]));
		details.appendChild(ad_name);
		
		Element adset_id = doc.createElement("adset_id");
		adset_id.appendChild(doc.createTextNode(data[2]));
		details.appendChild(adset_id);
		
		Element adset_name = doc.createElement("adset_name");
		adset_name.appendChild(doc.createTextNode(data[3]));
		details.appendChild(adset_name);
		
		Element campaign_id = doc.createElement("campaign_id");
		campaign_id.appendChild(doc.createTextNode(data[4]));
		details.appendChild(campaign_id);
		
		Element campaign_name = doc.createElement("campaign_name");
		campaign_name.appendChild(doc.createTextNode(data[5]));
		details.appendChild(campaign_name);
		
		Element form_id = doc.createElement("form_id");
		form_id.appendChild(doc.createTextNode(data[6]));
		details.appendChild(form_id);
		
		Element is_organic = doc.createElement("is_organic");
		is_organic.appendChild(doc.createTextNode(data[7]));
		details.appendChild(is_organic);
		
		Element availability= doc.createElement("availability");
		availability.appendChild(doc.createTextNode(data[8]));
		details.appendChild(availability);
		
		Element budget= doc.createElement("budget");
		budget.appendChild(doc.createTextNode(data[9]));
		details.appendChild(budget);
				
		Element name= doc.createElement("name");
		name.appendChild(doc.createTextNode(data[10]));
		details.appendChild(name);
		
		Element location= doc.createElement("location");
		location.appendChild(doc.createTextNode(data[11]));
		details.appendChild(location);
		
		Element mobile= doc.createElement("mobile");
		mobile.appendChild(doc.createTextNode(data[12]));
		details.appendChild(mobile);
		
		}
		
		

		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("/home/sid/Lead.xml"));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");

		}
	  }
	  catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}
