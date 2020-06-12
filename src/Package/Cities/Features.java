package Package.Cities;

final class Features {
    private static int scale;
    private static int xStart;
    private static int yStart;
    private static int xEnd;
    private static int yEnd;


    public static void position(int xStart, int yStart, int xEnd, int yEnd) {
        Features.xStart = xStart;
        Features.yStart = yStart;
        Features.xEnd = xEnd;
        Features.yEnd = yEnd;

        int deltaX = xEnd - xStart;
        int deltaY = yEnd - yStart;

        scale = deltaX > deltaY ? deltaX / 20 : deltaY / 20;
        System.out.println();
    }

    public static void printCities(Cities cities) {
        for (int i = 0; i < cities.getSize(); i++) {
            City currentCity = cities.getCity(i);
            System.out.println(currentCity.getName() + ": x " + currentCity.getX() / scale + ", y " + currentCity.getY() / scale);
        }
    }

    public static void printMap(Cities cities) {
        int deltaX = xEnd - xStart;
        int deltaY = yEnd - yStart;

        boolean printCity = false;
        int nameLength = 0;
        String nameCity = "";
        for (int i = 0; i < deltaX / scale; i++) {
            for (int j = 0; j < deltaY / scale; j++) {
                for (int k = 0; k < cities.getSize(); k++) {
                    City currentCity = cities.getCity(k);

                    if (currentCity.getX() / scale == i && currentCity.getY() / scale == j) {
                        nameCity = currentCity.getName();
                        nameLength = nameCity.length();
                        printCity = true;
                        break;
                    }
                }
                if(printCity) {
                    System.out.print("* ");
                    printCity = false;
                } else if (nameLength > 1) {
                    nameLength -=2;
                    System.out.print(nameCity.charAt(0));
                    System.out.print(nameCity.charAt(1));
                    nameCity = nameCity.substring(2);
                } else if (nameLength > 0) {
                    System.out.print(nameCity.charAt(0) + " ");
                    nameLength--;
                } else {
                    System.out.print("_ ");
                }
            }
            nameLength = 0;
            nameCity = "";
            System.out.println();
        }
    }

    public static Cities getVisibleCities(Cities cities) {
        Cities resultCities = new Cities();
        System.out.println("scale: " + scale);
        boolean visible = true;
        for (int i = 0; i < cities.getSize(); i++) {
            for (int j = 0; j < cities.getSize(); j++) {
                if (Math.abs(cities.getCity(i).getX() - cities.getCity(j).getX()) < scale || Math.abs(cities.getCity(i).getY() - cities.getCity(j).getY()) < scale) {
                    if (cities.getCity(i).getPopulation() * cities.getCity(i).getImportance() < cities.getCity(j).getPopulation() * cities.getCity(j).getImportance()) {
                        visible = false;
                        break;
                    }
                }
            }
            if (visible) {
                resultCities.addCity(cities.getCity(i));
            }
            visible = true;
        }
        return resultCities;
    }
}
