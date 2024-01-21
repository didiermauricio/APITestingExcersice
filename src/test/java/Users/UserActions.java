package Users;


import  static io.restassured.RestAssured.given;

import Commons.UserUrls;
import data.userModel;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserActions {

	public static Response CreateSingleUser(userModel user) {
		Response response = given()
								.filter(new AllureRestAssured())
								.contentType(ContentType.JSON)
								.header("api_key","12345")
								.body(user)
							.when()
								.post(UserUrls.newUserEndPoint);		
		
		return response;
	}
	
	public static Response SearchByUserName(String username) {
		Response response = given()
								.pathParam("username", username)
							.when()
								.get(UserUrls.searchByUserNameEndPoint);
		return response;
	}
	
}
