package Package.Lesson19;

public final class StudentGenerator {


    public static Student generator(){
        Student randomStudent = new Student(randomName(), randomNumber(16, 50), 10);
        for (int i = 0; i < 10; i++) {
            randomStudent.setAttendance(randomBoolean(), i);
            randomStudent.setMarks(randomNumber(0, 10), i);
        }
        return randomStudent;
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

    private static int randomNumber(int min, int max) {
        int numRange = max - min;
        return (int) (Math.random() * numRange + min);
    }

    private static boolean randomBoolean(){
        return Math.random() < 0.5;
    }
}
