package BeanCancel;

import java.util.List;

public class payload {
	
	
	String user;
	company company;
	account account;
	String addonInstance;
	String addonBinding;
	String order;
	public configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(configuration configuration) {
		this.configuration = configuration;
	}
	String notice;
	
	configuration configuration;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public company getCompany() {
		return company;
	}
	public void setCompany(company company) {
		this.company = company;
	}
	
	public account getAccount() {
		return account;
	}
	public void setAccount(account account) {
		this.account = account;
	}
	public String getAddonInstance() {
		return addonInstance;
	}
	public void setAddonInstance(String addonInstance) {
		this.addonInstance = addonInstance;
	}
	public String getAddonBinding() {
		return addonBinding;
	}
	public void setAddonBinding(String addonBinding) {
		this.addonBinding = addonBinding;
	}
	
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	

	
	
	
	
}
