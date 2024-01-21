package Commons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import io.restassured.response.Response;

public class JsonFunctions {
	
	public List<Pair<String, String>> GetJsonListByTuple(Response response, String entry1, String entry2) {
		 
		List<Pair<String,String>> finalList= new ArrayList<Pair<String,String>>();
		List<String> jsonResponse1 = response.jsonPath().getList(entry1);			
		List<String> jsonResponse2 = response.jsonPath().getList(entry2);
					
		//List<Pair> finalList = new ArrayList<Pair>();
		Pair<String, String> pair = null;
		for(int i=0; i<= jsonResponse1.size()-1;i++) {
			if(jsonResponse1!=null && jsonResponse1!=null && (jsonResponse1.size()==jsonResponse2.size()))
			{
				if(String.valueOf(jsonResponse2.get(i).toLowerCase()) !=null) {
				pair =  Pair.of(String.valueOf(jsonResponse1.get(i)),String.valueOf(jsonResponse2.get(i)).toLowerCase());	
				finalList.add(pair);			
				}
			}
		}
		return finalList;
	}

}
