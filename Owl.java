
public class Owl extends Bird{
	public Owl(String name, int age, int weight)
	{
		super(name, age, weight);
	}
	public type getType(){
		return type.OWL;
	}
	@Override
	public String getSound() {
		return "hoot";
	}
	public String getInfo() {
    	return super.getInfo() + "\n Type : " + getType() + " Sound : " + getSound(); 	
    }

}
