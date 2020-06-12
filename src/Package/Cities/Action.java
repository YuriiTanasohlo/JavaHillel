package Package.Cities;

public class Action {
    public static void run(){
        Features.position(0, 0, 200, 200);

        Cities cities = new Cities();
        setRandomCities(10, cities);
        Cities cities1 = Features.getVisibleCities(cities);

        System.out.println();
        System.out.println("Print all cities:");
        Features.printCities(cities);
        Features.printMap(cities);
        System.out.println();
        System.out.println("Print all visible cities:");
        Features.printCities(cities1);
        Features.printMap(cities1);
        System.out.println();
    }

    private static void setRandomCities(int count, Cities cities){
        int width = MapConfig.getWidth();
        int height = MapConfig.getHeight();
        int maxPopulation = MapConfig.getMaxPopulation();
        int maxValue = MapConfig.getMaxValue();

        for (int i = 0; i < count; i++) {
            cities.addCity(randomName(), randomNumber(width), randomNumber(height), randomNumber(maxPopulation), randomNumber(maxValue));
        }
    }

    private static int randomNumber(int diapason){
        return (int) (Math.random() * diapason);
    }

    private static String randomName() {
        String charString = "abcdefghijklmnopqrstuvwxyz";
        int lexiconLength = charString.length();
        int maxNameLength = 10;
        int minNameLength = 5;
        int rangeNameLength = maxNameLength - minNameLength + 1;
        int nameLength = (int) (Math.random() * rangeNameLength) + minNameLength;
        String name = "";
        for (int i = 0; i < nameLength; i++) {
            int letterPosition = (int) (Math.random() * lexiconLength);
            if (i == 0) {
                name += Character.toUpperCase(charString.charAt(letterPosition));
            } else {
                name += charString.charAt(letterPosition);
            }
        }
        return name;
    }
}
