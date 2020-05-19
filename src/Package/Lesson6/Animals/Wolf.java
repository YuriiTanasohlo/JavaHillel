package Package.Lesson6.Animals;

public class Wolf extends Wild{
    public Wolf(int age, int weight) {
        super(age, weight, "Grey", true);
    }

    @Override
    public String sayClass(){
        return this.getClass().getSimpleName();
    }
}
