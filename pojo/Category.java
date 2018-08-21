package pojo;
public class Category {

	private int ID;
    private String Title; 
    private int Parent_ID;
    private String Parent_name;
    private int Total_Childs;
    
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getParent_ID() {
		return Parent_ID;
	}
	public void setParent_ID(int parent_ID) {
		Parent_ID = parent_ID;
	}
	
	public String toString() {
		return Parent_name + ", " + Total_Childs;
	}
	public String getParent_name() {
		return Parent_name;
	}
	public void setParent_name(String parent_name) {
		Parent_name = parent_name;
	}
	public int getTotal_Childs() {
		return Total_Childs;
	}
	public void setTotal_Childs(int childs) {
		Total_Childs = childs;
	}
	
}
