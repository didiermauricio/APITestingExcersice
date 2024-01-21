package Pets;

import java.util.List;

import org.javatuples.Pair;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Commons.JsonFunctions;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class PetsTests {
	JsonFunctions json;
	PetsTuple_ID_Name_Structure tupleActions;
	
	@BeforeClass
	public void Setup() {
		json = new JsonFunctions();
		
	}
	
	
	@Test(priority = 1)
	public void Find_Pets_By_Status(){
		Response response = PetsActions.RetrievePetsByStatus("sold");
		response.then().log().all();					
		List<org.apache.commons.lang3.tuple.Pair<String, String>> list =  json.GetJsonListByTuple(response, "id", "name");
		tupleActions = new PetsTuple_ID_Name_Structure(list);
		tupleActions.ValidatePetNames();
	    	        
	}
	
}
