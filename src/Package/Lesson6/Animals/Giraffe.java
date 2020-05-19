package Package.Lesson6.Animals;

public class Giraffe extends Wild{
    public Giraffe(int age, int weight) {
        super(age, weight, "Yellow", false);
    }

    @Override
    public String sayClass(){
        return this.getClass().getSimpleName();
    }
}
