
public class Crocodile extends Reptile{
	public Crocodile(String name, int age, int weight){
		super(name, age, weight);
	}
	@Override
	public String getSound() {
		return null;
	}
	
	public type getType(){
		return type.CROCODILE;
	}
	public String getInfo() {
    	return super.getInfo() + "\nType : " + getType() + " Sound : " + getSound(); 	
    }

}
