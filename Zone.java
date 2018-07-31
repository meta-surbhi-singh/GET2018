import java.util.*;

public class Zone {
	List<Cage> cageList = new ArrayList<Cage>();
	String name;
	int noOfCagesAllowed;
	int currentCages;
	Animal.category category;

	Zone(String name, Animal.category category, int noOfCagesAllowed) {
		this.name = name;
		this.noOfCagesAllowed = noOfCagesAllowed;
		this.category = category;
	}

	public Animal.category getCategory() {
		return category;
	}

	public int getCageCapacity() {
		return noOfCagesAllowed;
	}

	public void addCage() {
		switch (category) {
		case BIRD: {
			cageList.add(new Cage(Animal.type.EAGLE, 5));
			cageList.add(new Cage(Animal.type.OWL, 3));
			//cageList.add(new Cage(Animal.type.OWL, 3));

			break;
		}
		case MAMMAL: {
			cageList.add(new Cage(Animal.type.LION, 1));
			//cageList.add(new Cage(Animal.type.LION, 1));
			//cageList.add(new Cage(Animal.type.LION, 1));
			cageList.add(new Cage(Animal.type.WOLF, 10));
			//cageList.add(new Cage(Animal.type.WOLF, 10));
			break;
		}
		case REPTILE: {
			//cageList.add(new Cage(Animal.type.SNAKE, 5));
			cageList.add(new Cage(Animal.type.SNAKE, 5));
			//cageList.add(new Cage(Animal.type.SNAKE, 5));
			//cageList.add(new Cage(Animal.type.CROCODILE, 1));
			cageList.add(new Cage(Animal.type.CROCODILE, 1));
			break;
		}
		}
	}

	public Cage getCage(Animal.type type) {
		for (int index = 0; index < cageList.size(); index++) {
			if (cageList.get(index).getType() == type && cageList.get(index).capacityAvailable()) {
				return cageList.get(index);
			}
		}
		return null;
	}

	public boolean cageAvailable() {
		if (cageList.size() < noOfCagesAllowed) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		for (int index = 0; index < cageList.size(); index++) {
			if(cageList.size() == 0) {
				System.out.println("No cages !!");
				continue;
			}
			else {
			System.out.println("CAGE " + (index + 1) + " of type " + cageList.get(index).getType());
			cageList.get(index).display();
			}
			System.out.println("\n\n");
		}
	}

	public boolean hasPark() {
		return true;
	}

	public boolean hasCanteen() {
		return false;
	}
}
