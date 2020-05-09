package Package.Lesson3;

import java.util.Arrays;

public class Students {
    //initiate some data for testing
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

    //Entire copy of the classGroup object. If newLengthDifference equals to -1 then return empty classGroup
    public Object[] classGroupCopy(Object[] classGroup, int newLengthDifference) {
        if (newLengthDifference != -1) {
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
        } else {
            return new Object[]{new String[]{}, new int[][]{}, new boolean[][]{}};
        }
    }


    public Object[] addNewStudent(String newStudentLastName, Object[] classGroup) {

        Object[] newClassGroup = classGroupCopy(classGroup, 1);
        ((String[]) newClassGroup[0])[((String[]) classGroup[0]).length] = newStudentLastName;

        return newClassGroup;
    }

    //Add new mark for the student
    public Object[] addMark(String studentLastName, int mark, Object[] classGroup) {

        int studentNumber = getStudentsNumber(studentLastName, classGroup);

        if (studentNumber != -1) {
            Object[] newClassGroup = classGroupCopy(classGroup, 0);

            int marksCountOfStudent = ((int[][]) newClassGroup[1])[studentNumber].length;
            int[] updatedMarksOfStudent = new int[marksCountOfStudent + 1];

            System.arraycopy(((int[][]) newClassGroup[1])[studentNumber], 0, updatedMarksOfStudent, 0, marksCountOfStudent);
            ((int[][]) newClassGroup[1])[studentNumber] = updatedMarksOfStudent;

            return updateMark(studentNumber, mark, marksCountOfStudent, newClassGroup);
        }
        System.out.println("There's no such student");
        return null;
    }


    //Update the mark for the student by lastName
    public Object[] updateMark(String studentLastName, int mark, int lesson, Object[] classGroup) {
        int studentNumber = getStudentsNumber(studentLastName, classGroup);

        if (studentNumber != -1) {
            return updateMark(studentNumber, mark, lesson, classGroup);
        }
        System.out.println("There's no such student");
        return null;
    }

    //Update the mark for the student by studentNumber
    public Object[] updateMark(int studentNumber, int mark, int lesson, Object[] classGroup) {

        Object[] updatedClassGroup = classGroupCopy(classGroup, 0);

        ((int[][]) updatedClassGroup[1])[studentNumber][lesson] = mark;
        return updatedClassGroup;

    }


    public int getStudentsNumber(String studentName, Object[] classGroup) {
        for (int i = 0; i < ((String[]) classGroup[0]).length; i++) {
            if (((String[]) classGroup[0])[i].equals(studentName)) {
                return i;
            }
        }
        return -1;
    }

    public Object[] sortGroupByLastName(Object[] classGroup) {
        Object[] updatedClassGroup = classGroupCopy(classGroup, 0);

        int studentsCount = ((String[]) updatedClassGroup[0]).length;

        int[] studentsNumber = new int[studentsCount];
        for (int i = 0; i < studentsCount; i++) {
            studentsNumber[i] = i;
        }

        for (int i = 0; i < studentsCount - 1; i++) {
            for (int j = i + 1; j < studentsCount; j++) {
                if (((String[]) updatedClassGroup[0])[i].compareTo(((String[]) updatedClassGroup[0])[j]) > 0) {
                    String tempName = ((String[]) updatedClassGroup[0])[i];
                    int[] tempMarks = ((int[][]) updatedClassGroup[1])[i];
                    boolean[] tempAttendance = ((boolean[][]) updatedClassGroup[2])[i];

                    ((String[]) updatedClassGroup[0])[i] = ((String[]) updatedClassGroup[0])[j];
                    ((int[][]) updatedClassGroup[1])[i] = ((int[][]) updatedClassGroup[1])[j];
                    ((boolean[][]) updatedClassGroup[2])[i] = ((boolean[][]) updatedClassGroup[2])[j];

                    ((String[]) updatedClassGroup[0])[j] = tempName;
                    ((int[][]) updatedClassGroup[1])[j] = tempMarks;
                    ((boolean[][]) updatedClassGroup[2])[j] = tempAttendance;
                }
            }
        }

        return updatedClassGroup;
    }

    public void printClassGroup(Object[] classGroup) {
        System.out.println("Students Group Information:");
        for (int i = 0; i < ((String[]) classGroup[0]).length; i++) {
            System.out.println("-----------------------------------------------");
            System.out.println("Student: " + ((String[]) classGroup[0])[i]);
            System.out.println("Marks: " + Arrays.toString(((int[][]) classGroup[1])[i]));
            System.out.println("Attendance: " + Arrays.toString(((boolean[][]) classGroup[2])[i]));
        }

    }

    public Object[] clearClassGroup(Object[] classGroup) {
        return classGroupCopy(classGroup, -1);
    }
}
