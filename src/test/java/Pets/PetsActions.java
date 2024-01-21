package Pets;


import  static io.restassured.RestAssured.given;

import Commons.PetsUrls;
import Commons.UserUrls;
import data.userModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetsActions {

	
	
	public static Response RetrievePetsByStatus(String status) {
		Response response = given()
				.param("status", status)								
							.when()
								.get(PetsUrls.findByStatusEndPoint);
		return response;
	}
	
}
