package Package.Lesson2;

import java.util.Scanner;

public class Draw {
    public void rectangle() {
        System.out.print("Please input length of the first side of the rectangle: ");
        Scanner input = new Scanner(System.in);
        int firstSide = input.nextInt();

        System.out.print("Please input length of the second side of the rectangle: ");
        input = new Scanner(System.in);
        int secondSide = input.nextInt();

        for (int i = 0; i < secondSide; i++) {
            String line = "";
            if (i == 0 || i + 1 == secondSide) {
                for (int j = 0; j < firstSide; j++) {
                    line += "*";
                }
            } else {
                for (int j = 0; j < firstSide; j++) {
                    if (j == 0 || j + 1 == firstSide) {
                        line += "*";
                    } else {
                        line += " ";
                    }

                }
            }
            System.out.println(line);
        }
        System.out.println("\n");
    }

    public void envelope() {

        System.out.print("Please input length of the first side of the envelope: ");
        Scanner input = new Scanner(System.in);
        double firstSide = input.nextInt();

        System.out.print("Please input length of the second side of the envelope: ");
        input = new Scanner(System.in);
        double secondSide = input.nextInt();

        double slopeSteepness = (firstSide - 1) / (secondSide - 1);

        for (int i = 0; i < secondSide; i++) {
            String line = "";
            if (i == 0 || i + 1 == secondSide) {
                for (int j = 0; j < firstSide; j++) {
                    line += "*";
                }
            } else {
                int positionFirstDiagonal = (int) Math.round(slopeSteepness * i);
                int positionSecondDiagonal = (int) Math.round(firstSide - slopeSteepness * i);

                for (int j = 0; j < firstSide; j++) {
                    if (j == 0 || j + 1 == firstSide || j == positionFirstDiagonal || j + 1 == positionSecondDiagonal) {
                        line += "*";
                    } else {
                        line += " ";
                    }

                }
            }
            System.out.println(line);
        }
        System.out.println("\n");
    }

    public void chess() {
        System.out.print("Please input length of the first side of the chess: ");
        Scanner input = new Scanner(System.in);
        int firstSide = input.nextInt();

        System.out.print("Please input length of the second side of the chess: ");
        input = new Scanner(System.in);
        int secondSide = input.nextInt();

        for (int i = 0; i < secondSide; i++) {
            String line = "";

            if (i%2==0) {
                for (int j = 0; j < firstSide; j++) {
                    if (j%2==0) {
                        line += "*";
                    } else {
                        line += " ";
                    }
                }
            } else {
                for (int j = 0; j < firstSide; j++) {
                    if (j%2==0) {
                        line += " ";
                    } else {
                        line += "*";
                    }
                }
            }
            System.out.println(line);
        }
        System.out.println("\n");
    }
}
