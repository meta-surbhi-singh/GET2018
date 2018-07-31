import java.util.*;

public class Zoo {
	List<Zone> zones = new ArrayList<Zone>();
	Scanner sc=new Scanner(System.in);
	public void addZone() {
		zones.add(new Zone("NORTH_ZONE", Animal.category.MAMMAL, 30));
		zones.add(new Zone("SOUTH_ZONE", Animal.category.REPTILE, 20));
		zones.add(new Zone("EAST_ZONE", Animal.category.BIRD, 10));
		zones.add(new Zone("WEST_ZONE", Animal.category.MAMMAL, 25));
		zones.add(new Zone("MIDDLE_ZONE", Animal.category.REPTILE, 5));
	}

	public void addCagesToZone() {
		for(int index = 0; index < zones.size(); index++) {
			zones.get(index).addCage();
		}
	}
	
	public void deleteAnimal() {
		System.out.println("Enter id of the dead animal : ");
		int id=sc.nextInt();
		for(int index = 0; index < zones.size(); index++) {
			for(int index1 = 0; index1 < zones.get(index).cageList.size(); index1++) {
				for(int index2 = 0; index2 < zones.get(index).cageList.get(index1).cageAnimalList.size(); index2++ )
				if(zones.get(index).cageList.get(index1).cageAnimalList.get(index2).getId()==id) {
			    zones.get(index).cageList.get(index1).removeAnimal(zones.get(index).cageList.get(index1).cageAnimalList.get(index2));}
				}
			}
		}
	
	public Zone getZone(Animal.category category) {
		for (int index = 0; index < zones.size(); index++) {
			if (zones.get(index).getCategory() == category && zones.get(index).cageAvailable()) {
				return zones.get(index);
			}
		}
		return null;
	}

	public void addAnimal(Animal.category category, Animal.type type, String name, int age, int weight) {
		Animal animal;
		switch (type) {
		case LION: {
			animal = new Lion(name, age, weight);
			break;
		}
		case WOLF: {
			animal = new Wolf(name, age, weight);
			break;
		}
		case SNAKE: {
			animal = new Snake(name, age, weight);
			break;
		}
		case CROCODILE: {
			animal = new Crocodile(name, age, weight);
			break;
		}
		case OWL: {
			animal = new Owl(name, age, weight);
			break;
		}
		case EAGLE: {
			animal = new Eagle(name, age, weight);
			break;
		}
		default: {
			System.out.println("type not specified");
			animal=null;
		}
		}
		if(getZone(category) != null && getZone(category).getCage(type) != null) {
			getZone(category).getCage(type).add(animal);
		}
		else {
			System.out.println("OPERATION FAILED..!!");
		}
	}
    
	public void displayAll() {
		 for (int index = 0; index < zones.size(); index++) {
			System.out.println("ZONE " + zones.get(index).name + " of category " + zones.get(index).getCategory());
			zones.get(index).display();
			System.out.println("\n\n\n");
		 }
	}

}
