package appdirect.services;

import appdirect.model.SuccesData;

public interface SubscriptionService {
	
	public SuccesData createSubscription(String eventUrl);
	public SuccesData cancelSubscription(String eventurl);
	
	

}
