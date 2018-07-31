

public class Snake extends Reptile{
	public Snake(String name, int age, int weight){
		super(name, age, weight);
	}
	
	public type getType(){
		return type.SNAKE;
	}
	
	@Override
	public String getSound() {
		return "hisss";
	}
	public String getInfo() {
    	return super.getInfo() + "\nType : " + getType() + " Sound : " + getSound(); 	
    }

}
