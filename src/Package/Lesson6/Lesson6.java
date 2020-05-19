package Package.Lesson6;

import Package.Lesson6.Animals.*;

public class Lesson6 {
    public void run() {
        Animal[] animals = createAnimals();
        for (Animal animal : animals) {
            System.out.println("ID:\t" + animal.getId() + ".\tType: " + animal.sayClass() + ".  " + animal.voice() + ". " + animal.seyColour());
        }

        System.out.println();

        Pet[] pets = createPet();
        for (Pet pet: pets) {
            System.out.println("ID:\t" + pet.getId() + ".\tType: " + pet.sayClass() + ".  " + pet.sayVaccine());
        }

        System.out.println();

        System.out.println("Average weight of the animals is " + averageWeight(animals));
        System.out.println("Average age of the animals is " + averageAge(animals));

        System.out.println();

        Guide guide2 = new Guide(12, 32, "Grey", "Pex", true, false);
        guide2.leadHome();
    }

    private Animal[] createAnimals() {
        Animal animal = new Animal(23, 59, "Blue");
        Cat cat = new Cat(4, 5, "Yellow", "Barsik", false);
        Crocodile crocodile = new Crocodile(5, 40);
        Dog dog = new Dog(34, 23, "Grey", "Doggy", true);
        Fish fish = new Fish(12, 32, "Grey");
        Giraffe giraffe = new Giraffe(12, 34);
        Guide guide = new Guide(12, 32, "Grey", "Rex", true, true);
        Guide guide1 = new Guide(12, 32, "Black", "Palkan", true, false);
        Hamster hamster = new Hamster(2, 1, "Brown", "Ham", true);
        Lion lion = new Lion(12, 45);
        Pet pet = new Pet(12, 3, "Black", "Wtf", false);
        Wild wild = new Wild(5, 2, "Red", true);
        Wolf wolf = new Wolf(4, 56);
        return new Animal[]{animal, cat, dog, fish, giraffe, crocodile, guide, guide1, hamster, lion, pet, wild, wolf};
    }

    private Pet[] createPet() {
        Cat cat = new Cat(4, 5, "Yellow", "Barsik", false);
        Dog dog = new Dog(34, 23, "Grey", "Doggy", true);
        Guide guide = new Guide(12, 32, "Grey", "Rex", true, true);
        Guide guide1 = new Guide(12, 32, "Black", "Palkan", true, false);
        Hamster hamster = new Hamster(2, 1, "Brown", "Ham", true);
        Pet pet = new Pet(12, 3, "Black", "Wtf", false);
        return new Pet[]{cat, dog, guide, guide1, hamster, pet};
    }

    private double averageWeight(Animal[] animals){
        int weightSum = 0;
        for (Animal animal: animals) {
            weightSum += animal.getWeight();
        }
        return weightSum/animals.length;
    }

    private double averageAge(Animal[] animals){
        int ageSum = 0;
        for (Animal animal: animals) {
            ageSum += animal.getAge();
        }
        return ageSum/animals.length;
    }

}
