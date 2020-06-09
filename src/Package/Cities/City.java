package Package.Cities;

public class City {

    private String name;
    private int x;
    private int y;
    private int population;
    private int importance;

    public City(String name, int x, int y, int population, int importance) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.population = population;
        this.importance = importance;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPopulation() {
        return population;
    }

    public int getImportance() {
        return importance;
    }
}
