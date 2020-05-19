package Package.Lesson6.Animals;

public class Wild extends Animal {
    private boolean isPredator;

    public Wild(int age, int weight, String colour, boolean isPredator) {
        super(age, weight, colour);
        this.isPredator = isPredator;
    }

    @Override
    public String voice() {
        return super.voice() + "I am a wild animal" + (isPredator ? " and I am angry" : "");
    }

    @Override
    public String sayClass(){
        return this.getClass().getSimpleName();
    }
}
