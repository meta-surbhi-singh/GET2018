
public abstract class Reptile extends Animal{
	public abstract type getType();
	
	public Reptile(String name, int age, int weight){
		super(name, age, weight);
	}
	@Override
	public category getCategory() {
		return category.REPTILE;
	}


}
