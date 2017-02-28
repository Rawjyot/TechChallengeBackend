package appdirect.services;

import BeanCancel.JavaJson;
import BeanCreate.JavaConvertJson;
import appdirect.dao.CancelSubscriptionDaoImpl;
import appdirect.dao.CreateSubscriptionDaoImpl;
import appdirect.model.Account;
import appdirect.model.Company;
import appdirect.model.Marketplace;
import appdirect.model.SuccesData;
import appdirect.model.Creator;
import appdirect.util.AccountExist;
import appdirect.util.AccountNotFound;
import appdirect.util.GetJsonObject;
import appdirect.util.HandleEventUrl;

public class SubscriptionServiceImpl implements SubscriptionService{

	
	JavaConvertJson javaObejct=null;
	
	@Override
	public SuccesData createSubscription(String eventUrl) {
		
		SuccesData succesData=new SuccesData();
		
		String eventData=HandleEventUrl.getJsonDataFromEventUrl(eventUrl);
	    javaObejct=GetJsonObject.getBeanObjectCreate(eventData);
		
		try 
		{	
			
		Boolean accountExist =	checkAccountExist(javaObejct);
		Boolean CompanyExist = checkCompanyAccountInMarketplace(javaObejct);
		
		if(accountExist == true && CompanyExist == true)
		{
			
		Account account  = Account.createAccount(javaObejct);
		Marketplace marketplace = Marketplace.crateMarketplace(javaObejct);
		Creator creator=Creator.createCreator(javaObejct);
		Company company=Company.createCompany(javaObejct);
		
		CreateSubscriptionDaoImpl createSubscriptionDaoImpl=new CreateSubscriptionDaoImpl();
		
		String account_identifier=getAccountIdentifier();
		
	    createSubscriptionDaoImpl.createAccount(account,account_identifier);
		createSubscriptionDaoImpl.createMarketplace(marketplace);
		createSubscriptionDaoImpl.createCreator(creator);
		createSubscriptionDaoImpl.createCompany(company);
		
		succesData.setAccountIdentifier(account_identifier);
		succesData.setSuccess("true");
		
		}
		else
		  {
			throw new AccountExist("Account Already Exits");
		  }
	   
		}
		catch (AccountExist e) {
			
			succesData.setSuccess("false");
			succesData.setErrorCode("202");
			succesData.setMessage("Account Exist");
			e.getMessage();
			e.printStackTrace();
			
		}
		catch (Exception e) {
		    e.getMessage();
		}
		
		
		return succesData;
	
	
	}
	@Override
	public SuccesData cancelSubscription(String eventurl) {
		
		SuccesData succesData=new SuccesData();
		String eventData=HandleEventUrl.getJsonDataFromEventUrl(eventurl);
		JavaJson javaObejct=GetJsonObject.getBeanObjectCancel(eventData);
		
		try
		{
			
		   Boolean accountExist=checkAccountExist(javaObejct);
		   
		   if(accountExist == false)
		   {
			   CancelSubscriptionDaoImpl cancelSubscriptionDaoImpl=new CancelSubscriptionDaoImpl();
			   cancelSubscriptionDaoImpl.deleteAccount(javaObejct);
			   succesData.setSuccess("true");
			   succesData.setAccountIdentifier(javaObejct.getPayload().getAccount().getAccountIdentifier());
			   succesData.setMessage("Subscription Cancelled");
		   }
		   else
		   {
			   throw new AccountNotFound();
			   
		   }
		}
		 catch (AccountNotFound e) {
			succesData.setSuccess("false");
			succesData.setErrorCode("404");
			succesData.setMessage("Account Not Found");
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return succesData;
	
		
	}
	public Boolean checkAccountExist(JavaJson javaObejct)
	{
		CreateSubscriptionDaoImpl cDaoImpl=new CreateSubscriptionDaoImpl();
	    Boolean checkAccount= cDaoImpl.checkAccount(javaObejct);
	    return checkAccount;
		
	}
	
	
	public Boolean checkAccountExist(JavaConvertJson javaObejct)
	{
		CreateSubscriptionDaoImpl cDaoImpl=new CreateSubscriptionDaoImpl();
	    Boolean checkAccount= cDaoImpl.checkAccount(javaObejct);
	    return checkAccount;
		
	}
	
	
	public Boolean checkCompanyAccountInMarketplace(JavaConvertJson javaObejct)
	{
		CreateSubscriptionDaoImpl cDaoImpl=new CreateSubscriptionDaoImpl();
	    Boolean checkComapny = cDaoImpl.checkMarketplace(javaObejct);
		return checkComapny;
	}
	
	
	
	static final String alphaNumericString = "abcdefghijklmnopqrstvuwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static int count = 20;
	public static String getAccountIdentifier()
	{
		 StringBuilder account_identifier = new StringBuilder();
		 while (count-- != 0) 
		       {
			   int character = (int)(Math.random()*alphaNumericString.length());
			   account_identifier.append(alphaNumericString.charAt(character));

			   }
		 
		return account_identifier.toString();
	}

	
}
