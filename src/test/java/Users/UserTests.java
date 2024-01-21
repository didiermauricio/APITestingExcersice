package Users;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import data.userModel;
import io.restassured.response.Response;

public class UserTests {
	userModel user; 

	@BeforeClass
	public void Setup() {
		user = new userModel();
		user.setId(0);
		user.setUsername("Didier");
		user.setFirstName("Didier Mauricio");
		user.setLastName("Sanabria");
		user.setEmail("didier@test.com");		
		user.setPassword("123abc");		
		user.setPhone("681642780");
		user.setUserStatus(0);
	}
	
	@Test(priority = 1)
	public void Create_A_Single_NewUser(){
		Response response = UserActions.CreateSingleUser(user);
		response.then().log().all();			
		
		Reporter.log(response.prettyPrint()); 
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void Search_An_ExistentUser(){
		Response response = UserActions.SearchByUserName("Didier");
		response.then().log().all();			
		
		Reporter.log(response.prettyPrint()); 
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("username"),user.getUsername());
		Assert.assertEquals(response.jsonPath().getString("firstName"),user.getFirstName());
		Assert.assertEquals(response.jsonPath().getString("lastName"),user.getLastName());
		Assert.assertEquals(response.jsonPath().getString("email"),user.getEmail());
		Assert.assertEquals(response.jsonPath().getString("password"),user.getPassword());
		Assert.assertEquals(response.jsonPath().getString("phone"),user.getPhone());
		
		
	}
	

	
}
