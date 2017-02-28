package appdirect.util;

public class AccountExist extends Exception {
	public AccountExist(String message) {
	super(message+"Error In Account Creation");
	}
}
