package appdirect.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import BeanCancel.JavaJson;
import BeanCreate.JavaConvertJson;
import appdirect.model.Account;
import appdirect.model.Company;
import appdirect.model.Creator;
import appdirect.model.Marketplace;
import appdirect.util.AccountExist;
import appdirect.util.DBConnectionManager;

public class CreateSubscriptionDaoImpl implements CreateSubscriptionDao{

	@Override
	        public void createMarketplace(Marketplace marketplace) {
	                String sql="insert into marketplace(mp_baseUrl,mp_partner) values (?,?)";
              try {
			        	System.out.println("In Marketplace"+marketplace);
			        try{
				            Connection con=(Connection) DBConnectionManager.getConnection();
				            PreparedStatement preparedStatement =(PreparedStatement) con.prepareStatement(sql);
				            preparedStatement.setString(1,marketplace.getBaseUrl());
				            preparedStatement.setString(2,marketplace.getPartner());
           		            preparedStatement.executeUpdate();
                        }
				        	catch (SQLException e) {
							        e.printStackTrace(); 
				        	}
                         System.out.println("Marketplace Added  Successfully");
                   }
                  catch (Exception e) 
                      {
                     e.printStackTrace();
                      }
	}

	@Override
	public void createAccount(Account acount,String account_identifier) {
		 String sql="insert into account(type,status,account_identifier) values (?,?,?) ";
	        try {
	            Connection con=(Connection) DBConnectionManager.getConnection();
	            try
	        	{
	            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
	            preparedStatement.setString(2,acount.getStatus());
	            preparedStatement.setString(1,acount.getType());
	            preparedStatement.setString(3,account_identifier);
	            
	            preparedStatement.executeUpdate();
	            
	            System.out.println("Account Added  Successfully");
	        	}
	        	catch(SQLException e) {
					e.printStackTrace();
				}
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	}
	@Override
	public void createCreator(Creator creator) {
		
        String sql="insert into creator(uuid,firstname,lastname,email) values (?,?,?,?)";
        try {
		        	System.out.println("In Creator"+creator);
		        try{
			            Connection con=(Connection) DBConnectionManager.getConnection();
			            PreparedStatement preparedStatement =(PreparedStatement) con.prepareStatement(sql);
			            preparedStatement.setString(1,creator.getUuid());
			            preparedStatement.setString(2,creator.getFirstname());
			            preparedStatement.setString(3,creator.getLastname());
			            preparedStatement.setString(4,creator.getEmail());
			            preparedStatement.executeUpdate();
                  }
			        	catch (SQLException e) {
						        e.printStackTrace(); 
			        	}
                   System.out.println("Creator Added  Successfully");
             }
            catch (Exception e) 
                {
               e.printStackTrace();
                }
		
		
		
		
		
	}

	@Override
	public void createCompany(Company company) {
		
        String sql="insert into company(uuid,name,email,phone_no,website,country) values (?,?,?,?,?,?)";
        try {
		        	System.out.println("In Company"+company);
		        try{
			            Connection con=(Connection) DBConnectionManager.getConnection();
			            PreparedStatement preparedStatement =(PreparedStatement) con.prepareStatement(sql);
			            preparedStatement.setString(1,company.getUuid());
			            preparedStatement.setString(2,company.getName());
			            preparedStatement.setString(3,company.getEmail());
			            preparedStatement.setString(4,company.getPhone_no());
			            preparedStatement.setString(5,company.getWebsite());
			            preparedStatement.setString(6,company.getCountry());
     		            preparedStatement.executeUpdate();
                  }
			        	catch (SQLException e) {
						        e.printStackTrace(); 
			        	}
                   System.out.println("Company Added  Successfully");
             }
            catch (Exception e) 
                {
               e.printStackTrace();
                }

		
		
		
		
	}

	@Override
	public Boolean checkAccount(JavaConvertJson javaConvertJson) {
		String uuid_exist_check= javaConvertJson.getCreator().getUuid();
		 String gettting_uuid_from_account=null;
		try{
			String accountExist = "SELECT * FROM account WHERE uuid = ? ";
			Connection con =(Connection) DBConnectionManager.getConnection();
		 	System.out.println(" In Connection");
			try {
				PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(accountExist);
				preparedStatement.setString(1,uuid_exist_check);
				   ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
				   while (resultSet.next()) {
		              gettting_uuid_from_account = resultSet.getString("uuid");
			   }
				   if(gettting_uuid_from_account!=null)
				   {
					   return true;
				   }
				   else
				   {
					   throw new AccountExist("Account Alreadt Exist");					   
				   }
			}
			catch (SQLException e) {
					e.printStackTrace();
					e.getMessage();
				}
			catch (Exception e) {
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public Boolean checkAccount(JavaJson javaConvertJson) {
		String uuid_exist_check= javaConvertJson.getCreator().getUuid();
		 String gettting_uuid_from_account=null;
		try{
			String accountExist = "SELECT * FROM account WHERE uuid = ? ";
			Connection con =(Connection) DBConnectionManager.getConnection();
		 	System.out.println(" In Connection");
			try {
				PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(accountExist);
				preparedStatement.setString(1,uuid_exist_check);
				   ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
				   while (resultSet.next()) {
		              gettting_uuid_from_account = resultSet.getString("uuid");
			   }
				   if(gettting_uuid_from_account!=null)
				   {
					   return true;
				   }
				   else
				   {
					   throw new AccountExist("Account Alreadt Exist");					   
				   }
			}
			catch (SQLException e) {
					e.printStackTrace();
					e.getMessage();
				}
			catch (Exception e) {
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
@Override
public Boolean checkMarketplace(JavaConvertJson javaConvertJson) {
	
	
    	String uuid_exist_check= javaConvertJson.getPayload().getCompany().getUuid();
	    String gettting_uuid_from_company=null;

	    try{
	    String companyExist = "SELECT * FROM company WHERE uuid = ? ";
		Connection con =(Connection) DBConnectionManager.getConnection();
	 	System.out.println(" In Connection");
		try {
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(companyExist);
			preparedStatement.setString(1,uuid_exist_check);
			   ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
			   while (resultSet.next()) 
			   {
	              gettting_uuid_from_company = resultSet.getString("uuid");
		       }
			   if(gettting_uuid_from_company!=null)
			   {
				   return true;
			   }
			   else
			   {
				   throw new AccountExist("Company Already Exist");					   
			   }
		}
		catch (SQLException e) {
				e.printStackTrace();
				e.getMessage();
			}
		catch (Exception e) {
		}
	}
	
	
	catch (Exception e) {
		e.printStackTrace();
	}
	return true;
	
}

}
