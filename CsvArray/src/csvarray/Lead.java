package csvarray;

public class Lead {
	
	
	String ad_id;  
	String ad_name;   
	String adset_id;  
	String adset_name;  
	String campaign_id;  
	String campaign_name;
	String form_id;
	String is_organic;
	String availability;
	String budget;
	String name;
	String location;
	String mobile;
	
	public String getAd_id() {
		return ad_id;
	}
	public void setAd_id(String data) {
		this.ad_id = data;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String data) {
		this.ad_name = data;
	}
	public String getAdset_id() {
		return adset_id;
	}
	public void setAdset_id(String data) {
		this.adset_id = data;
	}
	public String getAdset_name() {
		return adset_name;
	}
	public void setAdset_name(String data) {
		this.adset_name = data;
	}
	public String getCampaign_id() {
		return campaign_id;
	}
	public void setCampaign_id(String data) {
		this.campaign_id = data;
	}
	public String getCampaign_name() {
		return campaign_name;
	}
	public void setCampaign_name(String data) {
		this.campaign_name = data;
	}
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String data) {
		this.form_id = data;
	}
	public String getIs_organic() {
		return is_organic;
	}
	public void setIs_organic(String data) {
		this.is_organic = data;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String data) {
		this.availability = data;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String data) {
		this.budget = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String data) {
		this.name = data;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String data) {
		this.location = data;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String data) {
		this.mobile = data;
	}
	public String getInsertStatement() {
		String statement = 
				   "INSERT INTO LEAD"
							+ "(ad_id, ad_name, adset_id, adset_name,campaign_id,campaign_name,form_id,is_organic,availability,"
							+ "budget,name,location,mobile) VALUES("
							+"'"+(getAd_id()+"'"+","+"'"+getAd_name()+"'"+","+"'"+getAdset_id()+"'"+","+"'"+getAdset_name()+"'"+","+"'"+getCampaign_id()+"'"+","+"'"+getCampaign_name()
							+"'"+","+"'"+getForm_id()+"'"+","+"'"+getIs_organic()
							+"'"+","+"'"+getAvailability()+"'"+","+"'"+getBudget()+"'"+","+"'"+getName()
							+"'"+","+"'"+getLocation()+"'"+","+"'"+getMobile())+"'"+");";
		return statement;
	}
}
