package api.endpoints;
import static io.restassured.RestAssured.given;
import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints
{
	// for user module request
	public static Response createUser(user payload) 
	{
		Response response = given()
		   .accept(ContentType.JSON)// for kis type ka content accept krenga 
		   .contentType(ContentType.JSON) // for kis type ka content jayega
		   .body(payload)
		
		.when()
		.post(Routes.post_url);//we use Routes because post_url Routes class ka static variable h & to access static variable we need to use class name 
		
		return response;
	}
	public static Response GetUser(String userName) 
	{
		Response response = given()
		   .accept(ContentType.JSON)// for kis type ka content accept krenga 
		   .pathParam("username",userName)
		
		.when()
		.get(Routes.get_url);//we use Routes because post_url Routes class ka static variable h & to access static variable we need to use class name 
		
		return response;
	}
	public static Response UpdateUser(String userName,user payload) 
	{
		Response response = given()
		   .accept(ContentType.JSON)// for kis type ka content accept krenga 
		   .contentType(ContentType.JSON) // for kis type ka content jayega
		   .pathParam("username",userName)
		   .body(payload)
		
		.when()
		.put(Routes.put_url);//we use Routes because post_url Routes class ka static variable h & to access static variable we need to use class name 
		
		return response;
	}
	public static Response DeleteUser(String userName) 
	{
		Response response = given()
		   .accept(ContentType.JSON)// for kis type ka content accept krenga
		   .pathParam("username",userName)
		
		
		.when()
		.delete(Routes.del_url);//we use Routes because post_url Routes class ka static variable h & to access static variable we need to use class name 
		
		return response;
	}
}
