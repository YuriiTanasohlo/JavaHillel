package Package.Lesson6.Animals;

public class Guide extends Dog {
    private boolean isTrained;

    public Guide(int age, int weight, String colour, String name, boolean isVaccinated, boolean isTrained) {
        super(age, weight, colour, name, isVaccinated);
        this.isTrained = isTrained;
    }

    @Override
    public String voice() {
        return super.voice() + (isTrained ? "I can take you home." : "");
    }

    @Override
    public String sayClass(){
        return this.getClass().getSimpleName();
    }

    public void leadHome() {
        if(isTrained){
            System.out.println("You have been leaded at home");
        }else {
            System.out.println("I don't know how to lead");
        }
    }
}
