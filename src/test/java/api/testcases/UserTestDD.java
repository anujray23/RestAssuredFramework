package api.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTestDD
{
// because we will get data from ddt so we will not use fake data for  this here we will not use generate test data because we get data from excel file
	@Test(priority=1,dataProvider = "AllData",dataProviderClass = DataProvider.class)
	public void testCreateUser(String userId,String UserName,String fname,String lname,String email,String pwd,String phone)
	// for test data we will create parameter
	{
		
		user userPayload = new user();
		
		userPayload.setId(Integer.parseInt(userId));//here get data from above pass parameters
	
		userPayload.setUsername(UserName);
		userPayload.setFirstname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		// data get from different parameter
	Response response = userEndPoints.createUser(userPayload);
	//here we get response of the request 
		// now we can log the response
	// log response 
	response.then().log().all();

	// validation (now validate expected status code)
	Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=3,dataProvider = "UserNamesData",dataProviderClass = DataProvider.class)
	public void testDeleteUser(String username)
	{
		
		// static method call krne k liye classname and method directly can be used
		Response response = userEndPoints.DeleteUser(username);// kyunki hume user ka data read krna h pojo class se 
	    System.out.println("Delete User Data"); 	
		// here we get response of the request 
		// now we can log the response
		response.then().log().all();

		//validation (now validate expected status code)
	    
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
/*  @Test(priority=2,dataProvider = "UserNamesData", dataProviderClass = DataProvider.class)
  public void testGetUserData(String username);
  {
	  Response response = userEndPoints.GetUser(username);
	  response.then().log().all();
	  Assert.assertEquals(response.getStatusCode(),200);
	  
  }*/
}
