
public abstract class Animal {
	String name;
	public int age;
	int weight;
	int id;
	public static enum category { MAMMAL, BIRD, REPTILE }
	public static enum type { LION, WOLF, EAGLE, OWL,SNAKE, CROCODILE }
	public abstract category getCategory();
	
    public abstract String getSound();
    
    public Animal(String name, int age,	int weight) {
    	this.name=name;
    	this.age=age;
    	this.weight=weight;
    	this.id=getId();
    }
    public String getInfo() {
    	return  "ID : " + id + "\nName : " + name + "\nAge : " + age + " years and Weight : " + weight + " kgs  ";  	
    }
       
    public int getId() {
    	return hashCode();
    }
   
}
