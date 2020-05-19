package Package.Lesson6.Animals;

public class Lion extends Wild{
    public Lion(int age, int weight) {
        super(age, weight, "Yellow", true);
    }

    @Override
    public String sayClass(){
        return this.getClass().getSimpleName();
    }
}