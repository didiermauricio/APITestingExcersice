package Pets;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class PetsTuple_ID_Name_Structure {
	
	List<Pair<String,String>> tupleList;
	
	PetsTuple_ID_Name_Structure(List<Pair<String,String>> tuple){
		tupleList = tuple;			
	}
	
	public void ValidatePetNames() {
		
		List<Pair<String,String>> tupleListAux = tupleList;	
		
		tupleListAux.add(Pair.of("23","Garfield"));
		tupleListAux.add(Pair.of("24","Garfield"));
		tupleListAux.add(Pair.of("25","Garfield"));
		
		List<String> namesList = GetPetNamesList(tupleList);
		String petName=null;				
		int cont = 0;
		for(int i=0;i<=namesList.size()-1;i++)
		{
			for(int j=0; j<=tupleList.size()-1;j++)
			{
				petName = namesList.get(i);								
				Pair<String, String> tuple = tupleList.get(j);
				String tupleValue = tuple.getRight();
				
				if(namesList.get(i).equals(tupleValue)) {
					cont = cont+1;
				}
			}
			System.out.println("Pet "+ petName +" Name is repeated: "+cont);
			cont = 0;
		}
			
		}
	
	public List<String> GetPetNamesList(List<Pair<String,String>> list){
		List<String> petNamesList = new ArrayList<String>();
		for(int i = 0; i<=list.size()-1;i++) {
			Pair<String, String> tuple = list.get(i);
			if(!petNamesList.contains(tuple.getRight()))
			{
				petNamesList.add(tuple.getRight());   			    
			}			
		}
		return petNamesList;
	}
	
	
	
	

}
