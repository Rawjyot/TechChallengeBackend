package appdirect.model;

public class SuccesData {
	private String accountIdentifier;
	private String success;
	private String errorCode;
	private String message;
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SuccesData(String accountIdentifier,String success)
	{
		this.accountIdentifier=accountIdentifier;
		this.success=success;
		
		
	}
	
	public SuccesData()
	{
	 
	
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public String  getSuccess() {
		return success;
	}

	public void setSuccess(String string) {
		this.success = string;
	}

	
	
	
	
	
	

}
