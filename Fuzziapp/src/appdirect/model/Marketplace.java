package appdirect.model;

import BeanCancel.JavaJson;
import BeanCreate.JavaConvertJson;

public class Marketplace {

 private String partner;
 private String baseUrl;
 
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public static Marketplace crateMarketplace(JavaConvertJson javaObject)
	{
		
		Marketplace marketplace=new Marketplace();
		marketplace.setBaseUrl(javaObject.getMarketplace().getBaseUrl());
		marketplace.setPartner(javaObject.getMarketplace().getPartner());
		return marketplace;
		
	}
	

}
