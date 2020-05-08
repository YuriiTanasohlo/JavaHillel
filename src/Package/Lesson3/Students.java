package Package.Lesson3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Students {

    public Object[] defaultInitiateClassGroup() {
        String[] students = {
                "Masami",
                "Tokichiro",
                "Yoshiki",
                "Matabei",
                "Soichiro",
                "Shigetoki",
                "Motoyasu",
                "Mitsuzuka",
                "Seishisai",
                "Seiho"
        };

        int[][] marks = new int[students.length][10];
        boolean[][] attendance = new boolean[students.length][10];

        return new Object[]{students, marks, attendance};
    }


    public Object[] classGroupCopy(Object[] classGroup, int newLengthDifference) {

        int oldLength = ((String[]) classGroup[0]).length;

        String[] copyGroup = new String[oldLength + newLengthDifference];
        int[][] copyMarks = new int[oldLength + newLengthDifference][];
        boolean[][] copyAttendance = new boolean[oldLength + newLengthDifference][];

        System.arraycopy(classGroup[0], 0, copyGroup, 0, oldLength);
        System.arraycopy(classGroup[1], 0, copyMarks, 0, oldLength);
        System.arraycopy(classGroup[2], 0, copyAttendance, 0, oldLength);

        for (int i = 0; i < newLengthDifference; i++) {
            copyGroup[oldLength + i] = "";
            copyMarks[oldLength + i] = new int[((int[][]) classGroup[1]).length];
            copyAttendance[oldLength + i] = new boolean[((boolean[][]) classGroup[2]).length];
        }

        return new Object[]{copyGroup, copyMarks, copyAttendance};
    }


    public Object[] addNewStudent(String newStudentLastName, Object[] classGroup) {

        Object[] newClassGroup = classGroupCopy(classGroup, 1);
        ((String[]) newClassGroup[0])[((String[]) classGroup[0]).length] = newStudentLastName;

        return newClassGroup;
    }


    public Object[] addMark(String studentName, int mark, Object[] classGroup) {

        int i = contains(studentName, classGroup);

        if (i != -1) {
            Object[] newClassGroup = classGroupCopy(classGroup, 0);

            int marksCount = ((int[][]) newClassGroup[1])[i].length;
            int[] newMarks = new int[marksCount + 1];

            System.arraycopy(((int[][]) newClassGroup[1])[i], 0, newMarks, 0, marksCount);
            newMarks[marksCount] = mark;
            ((int[][]) newClassGroup[1])[i] = newMarks;

            return newClassGroup;
        }
        System.out.println("There's no such student");
        return classGroup;
    }


    public int contains(String studentName, Object[] classGroup) {
        for (int i = 0; i < ((String[]) classGroup[0]).length; i++) {
            if (((String[]) classGroup[0])[i].equals(studentName)) {
                return i;
            }
        }
        return -1;
    }
}
