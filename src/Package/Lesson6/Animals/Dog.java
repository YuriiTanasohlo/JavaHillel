package Package.Lesson6.Animals;

public class Dog extends Pet{
    public Dog(int age, int weight, String colour, String name, boolean isVaccinated) {
        super(age, weight, colour, name, isVaccinated);
    }

    @Override
    public String voice() {
        return super.voice() + "Woof";
    }

    @Override
    public String sayClass(){
        return this.getClass().getSimpleName();
    }
}
