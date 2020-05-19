package Package.Lesson6.Animals;

public class Fish extends Wild{
    public Fish(int age, int weight, String colour) {
        super(age, weight, colour, false);
    }

    @Override
    public String voice(){
        return "....";
    }

    @Override
    public String seyColour() {
        return "";
    }

    @Override
    public String sayClass(){
        return this.getClass().getSimpleName();
    }
}
