package Package.Lesson6.Animals;

public class Crocodile extends Wild{
    public Crocodile(int age, int weight) {
        super(age, weight, "Green", true);
    }

    @Override
    public String sayClass(){
        return this.getClass().getSimpleName();
    }
}


