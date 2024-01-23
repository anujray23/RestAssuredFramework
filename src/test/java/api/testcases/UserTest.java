package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest 
{
Faker faker;// to genrate fake object here faker is object and Faker is class
user userPayload; // user is class name and variable is userPayload

@BeforeClass
public void generateTestData()// before class mean this method will execute first to other methods
{
faker = new Faker();	// here above object k liye memory allocate kr rhe h
// now to set fake data we will create an object of the user.java class of payload
// userPayload m fake data set krenge
userPayload = new user();
// now we are starting to generate fake data
//userPayload.setId(faker.idNumber().hashCode());//hascode to generate unique id at everytime 
// here fake id generate hoga and wo id set ho jayega userPayload par so here UserTest class generate kiya h for validation yhi par data generate kr rhe h
//as we generate id similarly we need to generate other variables/data
userPayload.setId(faker.idNumber().hashCode());
userPayload.setUsername(faker.name().username());
userPayload.setFirstname(faker.name().firstName());
userPayload.setLastname(faker.name().lastName());
userPayload.setEmail(faker.internet().safeEmailAddress());
userPayload.setPassword(faker.internet().password(5,10));
userPayload.setPhone(faker.phoneNumber().cellPhone());

}
// now we need to call userendpoints class k create method ko in usertest.java class
@Test(priority=1)
public void testCreateUser()
{
	// static method call krne k liye classname and method directly can be used
Response response = userEndPoints.createUser(userPayload);
//here we get response of the request 
	// now we can log the response
// log response 
response.then().log().all();

// validation (now validate expected status code)
Assert.assertEquals(response.getStatusCode(),200);
}

@Test(priority=2)
public void testGetuser()
{
	// static method call krne k liye classname and method directly can be used
	Response response = userEndPoints.GetUser(this.userPayload.getUsername());// kyunki hume user ka data read krna h pojo class se 
    System.out.println("Read user Data");
	// here we get response of the request 
	// now we can log the response
	response.then().log().all();

	//validation (now validate expected status code)
    
	Assert.assertEquals(response.getStatusCode(),200);
	
}


@Test(priority=3)
public void testUpdateUser()
{
	userPayload.setFirstname(faker.name().firstName()); // first name change
	// static method call krne k liye classname and method directly can be used
	Response response = userEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload);// kyunki hume user ka data read krna h pojo class se 
 
	// here we get response of the request 
	// now we can log the response
	response.then().log().all();

	//validation (now validate expected status code)
    
	Assert.assertEquals(response.getStatusCode(),200);
	// Read user data to check first name is updated or not
	Response responsePostUpdate = userEndPoints.GetUser(this.userPayload.getUsername());
	   System.out.println("After Update user Data");
	responsePostUpdate.then().log().all();
}

@Test(priority=4)
public void testDeleteUser()
{
	
	// static method call krne k liye classname and method directly can be used
	Response response = userEndPoints.DeleteUser(this.userPayload.getUsername());// kyunki hume user ka data read krna h pojo class se 
    System.out.println("Delete User Data"); 	
	// here we get response of the request 
	// now we can log the response
	response.then().log().all();

	//validation (now validate expected status code)
    
	Assert.assertEquals(response.getStatusCode(),200);
	
}



}