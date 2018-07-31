
public class Lion extends Mammal {

	public Lion(String name, int age, int weight) {
		super(name, age, weight);
	}

	public type getType() {
		return type.LION;
	}

	@Override
	public String getSound() {
		return "roar";
	}
	public String getInfo() {
    	return super.getInfo() + "\nType : " + getType() + " Sound : " + getSound(); 	
    }
}
