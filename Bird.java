

public abstract class Bird extends Animal{
	public abstract type getType();
	
	public Bird(String name, int age, int weight){
		super(name, age, weight);
	}
	@Override
	public category getCategory() {
		return category.BIRD;
	}
}
