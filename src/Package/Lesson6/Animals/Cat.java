package Package.Lesson6.Animals;

public class Cat extends Pet{
    public Cat(int age, int weight, String colour, String name, boolean isVaccinated) {
        super(age, weight, colour, name, isVaccinated);
    }

    @Override
    public String voice() {
        return super.voice() + "Meow";
    }

    @Override
    public String sayClass(){
        return this.getClass().getSimpleName();
    }
}
