package Package.Cities;

public final class Cities {
    City[] cities = new City[0];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void addCity(String name, int x, int y, int population, int importance) {
        if (size == cities.length) {
            increaseArray();
        }
        cities[size] = new City(name, x, y, population, importance);
        size++;
    }

    public void addCity(City city) {
        if (size == cities.length) {
            increaseArray();
        }
        cities[size] = city;
        size++;
    }

    public City getCity(int index) {
        return new City(cities[index].getName(), cities[index].getX(), cities[index].getY(), cities[index].getPopulation(), cities[index].getImportance());
    }

    private void increaseArray() {
        City[] citiesCopy = new City[(int) ((cities.length + 1) * 1.5)];
        System.arraycopy(cities, 0, citiesCopy, 0, size);
        cities = citiesCopy;
    }
}
