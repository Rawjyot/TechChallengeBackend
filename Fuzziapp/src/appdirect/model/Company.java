package appdirect.model;

import BeanCancel.JavaJson;
import BeanCreate.JavaConvertJson;

public class Company {
	
     
	 private String uuid;
     private String name;
     private String email;
     private String phone_no;
     private String website;
     private String country;
     
     
     
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
     
     
     public static  Company createCompany(JavaConvertJson javaJson)
     {
    	 
    	 Company company=new Company();
    	 
    	 company.setName(javaJson.getPayload().getCompany().getUuid());
    	 company.setEmail(javaJson.getPayload().getCompany().getName());
    	 company.setPhone_no(javaJson.getPayload().getCompany().getPhoneNumber());
    	 company.setWebsite(javaJson.getPayload().getCompany().getWebsite());
    	 company.setCountry(javaJson.getPayload().getCompany().getCountry());
    	 
		 return company;
		 
    	 
     }
	
	
	
	
	
	
	

}
