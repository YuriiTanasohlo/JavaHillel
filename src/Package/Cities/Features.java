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

        scale = deltaX > deltaY ? deltaX / 10 : deltaY / 10;
        System.out.println();
    }

    public void printCities() {
        System.out.println();
    }

    public void printMap() {

    }

    public static Cities getVisibleCities(Cities cities){
        Cities resultCities = new Cities();
        System.out.println(scale);
        boolean visible = true;
        for (int i = 0; i < cities.getSize(); i++) {
            for (int j = 0; j < cities.getSize(); j++) {
                if(Math.abs(cities.getCity(i).getX() - cities.getCity(j).getX()) < scale || Math.abs(cities.getCity(i).getY() - cities.getCity(j).getY()) < scale){
                    if(cities.getCity(i).getPopulation() * cities.getCity(i).getImportance() < cities.getCity(j).getPopulation() * cities.getCity(j).getImportance()){
                        visible = false;
                        break;
                    }
                }
            }
            if(visible){
                resultCities.addCity(cities.getCity(i));
            }
            visible = true;
        }
        return resultCities;
    }
}
