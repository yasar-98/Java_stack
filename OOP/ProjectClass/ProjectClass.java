public class ProjectClass{
	private String name;	
	private String description;	
	
	public ProjectClass(){
	}
	public ProjectClass(String name){
		this.name=name;
	}
	public void ProjectClass(String name,String description){
		this.name=name;
		this.description=description;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}	
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description=description;
	}
}