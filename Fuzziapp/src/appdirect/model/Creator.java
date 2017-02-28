package appdirect.model;

import BeanCancel.JavaJson;
import BeanCreate.JavaConvertJson;

public class Creator {
	
	
	String uuid;
	String email;
	String firstname;
	String lastname;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	public static Creator createCreator(JavaConvertJson javaObject)
	{
		
	   Creator object=new Creator();
	  object.setUuid(javaObject.getCreator().getUuid());
	  object.setEmail(javaObject.getCreator().getEmail());
	  object.setFirstname(javaObject.getCreator().getFirstName());
	  object.setLastname(javaObject.getCreator().getLastName());
	
	return object;
	
	}
	
	

}
