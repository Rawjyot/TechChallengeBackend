package appdirect.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import BeanCancel.JavaJson;
import BeanCreate.JavaConvertJson;

   public class GetJsonObject {
	
	   public static JavaConvertJson getBeanObjectCreate(String responseJ){
    	JavaConvertJson javaObject=null;	
		ObjectMapper mapper =new ObjectMapper();
	                try {
	                	javaObject = mapper.readValue(responseJ, JavaConvertJson.class);
						System.out.println("JSON TO OBJECT CREATE");
					} catch (IOException e) {
						e.printStackTrace();
					}
					return javaObject;
	              }
	   
    public static JavaJson getBeanObjectCancel(String responseJ){
    	JavaJson responsejava = null;
		ObjectMapper mapper =new ObjectMapper();
	                try {
	                	
	                	responsejava = mapper.readValue(responseJ, JavaJson.class);
						
						System.out.println("JSON TO OBJECT CREATE");
					} catch (IOException e) {
					
						e.printStackTrace();
					}
	                return responsejava;
	      }
}
