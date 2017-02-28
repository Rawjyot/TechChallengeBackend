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

public class SubscriptionsCreate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("application/json");
		PrintWriter sentresponse = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
	    String eventUrl = (String) request.getParameter("eventUrl");
		SubscriptionServiceImpl subscription=new SubscriptionServiceImpl();
		
		try{
		SuccesData succesData =  subscription.createSubscription(eventUrl);
		succesData.getAccountIdentifier();
		succesData.getSuccess();
		succesData.getErrorCode();
		succesData.getMessage();
		String responseJson = mapper.writeValueAsString(succesData);
		sentresponse.print(responseJson);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}

}