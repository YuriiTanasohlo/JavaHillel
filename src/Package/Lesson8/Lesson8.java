package Package.Lesson8;

import java.util.Arrays;

public final class Lesson8 {
    public static void run(){
        HillelCollection hillelCollection1 = new HillelCollection(createTestObjects(3));

        startBlockTest("test size()");
        System.out.println(hillelCollection1.size());
        endBlockTest();

        startBlockTest("test isEmpty()");
        System.out.println(hillelCollection1.isEmpty());

        HillelCollection hillelCollection2 = new HillelCollection(createTestObjects(0));
        System.out.println(hillelCollection2.isEmpty());
        endBlockTest();

        startBlockTest("test contains()");
        HillelCollection hillelCollection3 = new HillelCollection(createTestObjects(3));
        System.out.println(hillelCollection3.contains(new ExampleObject(1 + " string")));
        System.out.println(hillelCollection3.contains(new ExampleObject(4 + " string")));
        endBlockTest();

        startBlockTest("test toArray()");
        HillelCollection hillelCollection4 = new HillelCollection(createTestObjects(3));
        System.out.println(Arrays.toString(hillelCollection4.toArray()));
        System.out.println(Arrays.toString(hillelCollection4.toArray(new Object[2])));
        System.out.println(Arrays.toString(hillelCollection4.toArray(new Object[4])));
        endBlockTest();

        startBlockTest("test add()");
        HillelCollection hillelCollection5 = new HillelCollection();
        System.out.println(hillelCollection5.add(new ExampleObject(1 + " string")));
        System.out.println(hillelCollection5.contains(new ExampleObject(1 + " string")));
        endBlockTest();

        startBlockTest("test remove()");
        System.out.println(hillelCollection5.remove(new ExampleObject(1 + " string")));
        System.out.println(hillelCollection5.contains(new ExampleObject(1 + " string")));
        endBlockTest();

        startBlockTest("test containsAll()");
        HillelCollection hillelCollection6 = new HillelCollection(createTestObjects(2));
        HillelCollection hillelCollection7 = new HillelCollection(createTestObjects(4));
        System.out.println(hillelCollection7.containsAll(hillelCollection6));
        hillelCollection6.add(new ExampleObject(5 + " string"));
        System.out.println(hillelCollection7.containsAll(hillelCollection6));
        endBlockTest();

        startBlockTest("test addAll()");
        HillelCollection hillelCollection8 = new HillelCollection(createTestObjects(2));
        HillelCollection hillelCollection9 = new HillelCollection(createTestObjects(4));
        System.out.println(hillelCollection9.size());
        hillelCollection9.addAll(hillelCollection8);
        System.out.println(hillelCollection9.size());
        endBlockTest();

        startBlockTest("test removeAll()");
        System.out.println(hillelCollection9.size());
        hillelCollection9.removeAll(hillelCollection8);
        System.out.println(hillelCollection9.size());
        endBlockTest();

        startBlockTest("test retainAll()");
        System.out.println(hillelCollection9.size());
        hillelCollection9.addAll(hillelCollection8);
        System.out.println(hillelCollection9.size());
        hillelCollection9.retainAll(hillelCollection8);
        System.out.println(hillelCollection9.size());
        endBlockTest();

        startBlockTest("test clear()");
        System.out.println(hillelCollection9.size());
        hillelCollection9.clear();
        System.out.println(hillelCollection9.size());
        hillelCollection9.add(new ExampleObject(1 + " string"));
        System.out.println(hillelCollection9.size());
        endBlockTest();
    }

    private static ExampleObject[] createTestObjects(int amount){
        ExampleObject[] exampleObjects = new ExampleObject[amount];
        for (int i = 0; i < amount; i++) {
            exampleObjects[i] = new ExampleObject(i + " string");
        }
        return exampleObjects;
    }

    private static void startBlockTest(String message) {
        printMessage(message);
    }

    private static void endBlockTest() {
        printMessage("test ended");
    }

    private static void printMessage(String message) {
        System.out.print("------------ ");
        System.out.print(message);
        System.out.println(" ------------");
    }
}
