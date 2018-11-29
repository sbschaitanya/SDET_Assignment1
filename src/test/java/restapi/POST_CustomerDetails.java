package restapi;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class POST_CustomerDetails {
	HttpURLConnection con;
@Test
public void test() throws IOException, JSONException
{
	String link="http://restapi.demoqa.com/customer/register";
	URL url = new URL(link);
	con=(HttpURLConnection)url.openConnection() ;
	con.setRequestMethod("POST");
	con.setDoOutput(true);
	con.setRequestProperty("Accept", "application/json");
	
	JSONObject requestBody=new JSONObject();
	requestBody.append("FirstName", "Upendra");
	requestBody.append("LastName", "kumar");
	requestBody.append("UserName", "upen1");
	requestBody.append("Password", "Password1");
	requestBody.append("Email", "upen1@gmail.com");
	
	OutputStreamWriter writer=new OutputStreamWriter(con.getOutputStream());
	System.out.println(requestBody.toString());
	writer.write(requestBody.toString());
	writer.flush();
	writer.close();
	
	if(con.getResponseCode()!=200)
	{
		throw new RuntimeException("Failed : HTTP error code : "+con.getResponseCode());
	}
	else
	{
		System.out.println(con.getResponseCode());
		System.out.println(con.getResponseMessage());
	}
	con.disconnect();
	}
}
