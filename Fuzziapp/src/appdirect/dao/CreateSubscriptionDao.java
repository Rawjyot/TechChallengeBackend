package appdirect.dao;

import BeanCreate.JavaConvertJson;
import appdirect.model.Account;
import appdirect.model.Company;
import appdirect.model.Creator;
import appdirect.model.Marketplace;

public interface CreateSubscriptionDao {
	
	
	public Boolean checkAccount(JavaConvertJson javaConvertJson);
	public Boolean checkMarketplace(JavaConvertJson javaConvertJson);
	public void createMarketplace(Marketplace marketplace);
    public void createCreator(Creator creator);
    public void createAccount(Account account,String account_identifier);
    public void createCompany(Company company);
   
}
