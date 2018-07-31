

public abstract class Mammal extends Animal{
	
	public abstract type getType();
	public Mammal(String name, int age,	int weight)
	{
		super(name, age, weight);
	}
	@Override
	public category getCategory() {
		return category.MAMMAL;
	}
	
	
}
