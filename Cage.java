import java.util.ArrayList;
import java.util.List;

public class Cage {
	Animal.type type;
	int capacity;
	List<Animal> cageAnimalList=new ArrayList<Animal>();
	
	public Cage(Animal.type type,int capacity) {
		this.type=type;
		this.capacity=capacity;
	}
	
	public Animal.type getType(){
		return type;
	}
	
	public boolean capacityAvailable() {
		if(cageAnimalList.size() < capacity) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void add(Animal animal) {
		cageAnimalList.add(animal);			
	}
	
	public void removeAnimal(Animal animal) {
    	cageAnimalList.remove(animal);
	}
    
	public void display() {
		for(int index = 0; index < cageAnimalList.size(); index++) {
			if(cageAnimalList.size() != 0) {
				System.out.println(cageAnimalList.get(index).getInfo());
			}
			else {
				System.out.println("EMPTY CAGE!");
			}
			System.out.println("\n");
		}
	}
}
