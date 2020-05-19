package Package.Lesson6.Animals;

public class Hamster extends Pet{
    public Hamster(int age, int weight, String colour, String name, boolean isVaccinated) {
        super(age, weight, colour, name, isVaccinated);
    }

    @Override
    public String sayClass(){
        return this.getClass().getSimpleName();
    }
}
