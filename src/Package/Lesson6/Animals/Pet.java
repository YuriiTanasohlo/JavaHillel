package Package.Lesson6.Animals;

public class Pet extends Animal {
    private String name;
    private boolean isVaccinated;

    public Pet(int age, int weight, String colour, String name, boolean isVaccinated) {
        super(age, weight, colour);
        this.name = name;
        this.isVaccinated = isVaccinated;
    }

    @Override
    public String voice() {
        return super.voice() + (name == null || name.equals("") ? "" : "my name is " + name + ". ");
    }

    @Override
    public String sayClass() {
        return this.getClass().getSimpleName();
    }

    public String sayVaccine() {
        return isVaccinated ? "I'm vaccinated and in safety." : "Why don't you vaccinate me?";
    }
}
