package appdirect.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BeanCancel.JavaJson;
import appdirect.util.DBConnectionManager;

public class CancelSubscriptionDaoImpl implements CancelSubscriptionDao {

	@Override
	public void deleteAccount(JavaJson javaJson) {
		
		String uuid_delete=javaJson.getCreator().getUuid();
	    try
     	{
         String sql = "DELETE FROM account WHERE mp_id = ?";
     	 Connection con=(Connection) DBConnectionManager.getConnection();
         PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
         preparedStatement.setString(1,uuid_delete);
         preparedStatement.executeUpdate();
         System.out.println("  Account  Deleted  Successfully");
         
     	
     	}
     	catch(SQLException e)
	    {
				e.printStackTrace();
	    }
        
    	}
    	
	@Override
	public void deleteMarketplace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(String eventUrl) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
