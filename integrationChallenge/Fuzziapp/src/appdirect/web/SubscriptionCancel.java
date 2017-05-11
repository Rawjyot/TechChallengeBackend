package appdirect.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import appdirect.model.SuccesData;
import appdirect.services.SubscriptionServiceImpl;
import appdirect.util.AccountExist;

public class SubscriptionCancel extends HttpServlet {
	
	SuccesData succesData;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("application/json");
		PrintWriter responseCancel = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String eventUrl = (String) request.getParameter("eventUrl");
		SubscriptionServiceImpl subscription=new SubscriptionServiceImpl();
		try{
	          succesData=subscription.cancelSubscription(eventUrl);
	          String jasonData = mapper.writeValueAsString(succesData);
	          responseCancel.print(jasonData);
	  		
		  }
		
	
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
        
		
}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//TODO
}

	

}
