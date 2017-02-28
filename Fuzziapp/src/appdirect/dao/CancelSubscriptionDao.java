package appdirect.dao;

import BeanCancel.JavaJson;


public interface CancelSubscriptionDao {
	
	
	public void deleteAccount(String eventUrl);
	public void deleteMarketplace();
	void deleteAccount(JavaJson javaJson);
	

}
