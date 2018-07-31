

public class ZooRunner {
	
	public static void main(String args[]) {
		
		Zoo zoo=new Zoo();
		zoo.addZone();
		zoo.addCagesToZone();
		//ZooManagementSystem zooSystem=new ZooManagementSystem();
		zoo.addAnimal(Animal.category.MAMMAL, Animal.type.LION, "Simba", 35, 70);
		zoo.addAnimal(Animal.category.MAMMAL, Animal.type.WOLF, "Akela", 55, 80);
		zoo.addAnimal(Animal.category.REPTILE, Animal.type.SNAKE, "Kaa", 100, 50);
		zoo.addAnimal(Animal.category.REPTILE, Animal.type.CROCODILE, "Pumbaa", 48, 150);
		zoo.addAnimal(Animal.category.MAMMAL,  Animal.type.WOLF, "Raksha", 57, 85);
		zoo.addAnimal(Animal.category.BIRD, Animal.type.EAGLE, "Cheel", 90, 50);
		zoo.addAnimal(Animal.category.BIRD, Animal.type.OWL, "Rafiki", 125, 45);
	    zoo.addAnimal(Animal.category.REPTILE,  Animal.type.SNAKE, "Kiara", 45, 70);
     	
	    zoo.displayAll();	
	    zoo.deleteAnimal();
	    zoo.displayAll();
	}

}
