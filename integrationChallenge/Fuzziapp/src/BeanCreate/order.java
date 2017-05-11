package BeanCreate;

import java.util.List;

public class order {
	
	
	String editionCode;
	String addonOfferingCode;
	String pricingDuration;
	String[] customAttributes;
	 List<items> items;
	 
	public String getEditionCode() {
		return editionCode;
	}
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}
	public String getAddonOfferingCode() {
		return addonOfferingCode;
	}
	public void setAddonOfferingCode(String addonOfferingCode) {
		this.addonOfferingCode = addonOfferingCode;
	}
	public String getPricingDuration() {
		return pricingDuration;
	}
	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}
	
	public String[] getCustomAttributes() {
		return customAttributes;
	}
	public void setCustomAttributes(String[] customAttributes) {
		this.customAttributes = customAttributes;
	}
	public List<items> getItems() {
		return items;
	}
	public void setItems(List<items> items) {
		this.items = items;
	}
	
	
	
	
	
}