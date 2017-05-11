package appdirect.model;

import BeanCancel.JavaJson;
import BeanCreate.JavaConvertJson;
import appdirect.util.AccountExist;
import appdirect.util.AccountNotFound;

public class Account {

	
	String account_identifier;
	String status;
	String type;
	
	
	
	public String getAccount_identifier() {
		return account_identifier;
	}



	public void setAccount_identifier(String account_identifier) {
		this.account_identifier = account_identifier;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public static Account createAccount(JavaConvertJson javaObject) throws AccountExist, AccountNotFound
	{
	
		Account account=new Account();
		account.setStatus("Active");
		account.setType(javaObject.getType());
		
		return account;
	
	}

	
	
	
	
}
	

