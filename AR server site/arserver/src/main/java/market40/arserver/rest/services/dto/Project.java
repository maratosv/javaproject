package market40.arserver.rest.services.dto;

import java.util.List;


public class Project {
	String name;
	String id;
	List<String> listStrings; 
	List<Integer> listInt; 
	
	public String getName() {
		return name;
	}
	public void setMachineName(String name) {
		this.name = name;
	}
	public void setCompanyName(String name) {
		this.name = name;
	}
	
	//public void setRating(int id, int rate) {
		
	//}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
			
		this.id = id;
	}
	

	
//	public void listINPUTS(int id,String name)
//	{
//		listStrings.add(name);
//		listInt.add(id);
//		
//	}
	
}