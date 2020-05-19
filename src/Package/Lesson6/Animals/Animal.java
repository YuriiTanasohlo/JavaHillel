package Package.Lesson6.Animals;

public class Animal {
    private int id;
    private static int nextId = 1;
    private int age;
    private int weight;
    private String colour;

    public Animal(int age, int weight, String colour) {
        this.id = nextId++;
        this.age = age;
        this.weight = weight;
        this.colour = colour;
    }

    public String voice(){
        return "Hello, ";
    }

    public String seyColour(){
        return "My colour is " + colour + ".";
    }

    public String sayClass(){
        return this.getClass().getSimpleName();
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }
}
