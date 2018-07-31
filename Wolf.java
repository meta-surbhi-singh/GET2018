
public class Wolf extends Mammal{
	public Wolf(String name, int age, int weight)
	{
		super(name, age, weight);
	}
	public type getType(){
		return type.WOLF;
	}
	@Override
	public String getSound() {
		return "howl";
	}
	
	public String getInfo() {
    	return super.getInfo() + "\nType : " + getType() + " Sound : " + getSound(); 	
    }

}
