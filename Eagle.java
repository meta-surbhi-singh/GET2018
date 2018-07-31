
public class Eagle extends Bird {
	public Eagle(String name, int age, int weight)
	{
		super(name, age, weight);
	}
	public type getType(){
		return type.EAGLE;
	}
	@Override
	public String getSound() {
		return "screech";
	}
	public String getInfo() {
	    	return super.getInfo() + "\nType : " + getType() + " Sound : " + getSound(); 	
	    }
	       


}
