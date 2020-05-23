package Package.Lesson7;

public final class Lesson7 {
    public void run() {

        Object[] objects = new Object[3];

        objects[0] = new MyObject("string1");
        objects[1] = 5.5;
        objects[2] = "Element 2 String";

        startBlockTest("test size() & constructor without argument & isEmpty()");
        MyCollection collection = new MyCollection();
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        endBlockTest();


        startBlockTest("test size() & constructor with argument & isEmpty()");
        collection = new MyCollection(objects);
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        endBlockTest();

        startBlockTest("test getElement()");
        System.out.println(((MyObject) collection.getElement(0)).getMyString());
        System.out.println(collection.getElement(2));
        endBlockTest();

        startBlockTest("test contains()");
        Object[] objects1 = new Object[]{555, 666, 77.7};
        MyCollection collection1 = new MyCollection(objects1);
        System.out.println(collection1.getElement(1));
        System.out.println(objects1[1]);
        System.out.println(collection1.contains(555));
        MyObject myObject = new MyObject("string2");
        collection1.add(myObject);
        System.out.println(collection1.contains(myObject));
        System.out.println(collection1.contains(collection1.getElement(0)));
        endBlockTest();

        startBlockTest("test add()");
        System.out.println(collection.add(755));
        System.out.println(collection.add("string3"));
        System.out.println(collection.add(new MyObject("string4")));
        System.out.println(collection.getElement(3));
        System.out.println(collection.getElement(4));
        System.out.println(((MyObject) collection.getElement(5)).getMyString());
        MyCollection collection2 = new MyCollection();
        System.out.println(collection2.add(new MyObject("string5")));
        System.out.println(((MyObject) collection2.getElement(0)).getMyString());
        endBlockTest();

        startBlockTest("test remove()");
        Object[] objects2 = new Object[]{555, 666, 777, 888, 999};
        MyCollection collection3 = new MyCollection(objects2);
        System.out.println(collection3.contains(666));
        System.out.println(collection3.size());
        System.out.println(collection3.remove(666));
        System.out.println(collection3.contains(666));
        System.out.println(collection3.size());
        System.out.println(collection3.getElement(4));
        endBlockTest();

        startBlockTest("test addAll()");
        Object[] objects3 = new Object[]{555, 666, 777, 888, 999};
        Object[] objects4 = new Object[]{111, 222, 333};
        Object[] objects5 = new Object[]{};
        MyCollection collection4 = new MyCollection(objects3);
        MyCollection collection5 = new MyCollection(objects4);
        MyCollection collection6 = new MyCollection(objects5);
        System.out.println(collection4.size());
        System.out.println(collection4.addAll(collection5));
        System.out.println(collection4.size());
        System.out.println(collection4.addAll(collection6));
        System.out.println(collection4.size());
        endBlockTest();

        startBlockTest("test clear()");
        System.out.println(collection4.size());
        collection4.clear();
        System.out.println(collection4.size());
        endBlockTest();

        startBlockTest("test retainAll()");
        Object[] objects6 = new Object[]{555, 666, 777, 888, 999};
        Object[] objects7 = new Object[]{0, 777, 666};
        MyCollection collection7 = new MyCollection(objects6);
        MyCollection collection8 = new MyCollection(objects7);
        System.out.println(collection7.size());
        System.out.println(collection7.retainAll(collection8));
        System.out.println(collection7.size());
        endBlockTest();

        startBlockTest("test removeAll()");
        Object[] objects8 = new Object[]{555, 666, 777, 888, 999};
        Object[] objects9 = new Object[]{0, 777, 666};
        MyCollection collection9 = new MyCollection(objects8);
        MyCollection collection10 = new MyCollection(objects9);
        System.out.println(collection9.size());
        System.out.println(collection9.removeAll(collection10));
        System.out.println(collection9.size());
        endBlockTest();

        startBlockTest("test containsAll()");
        Object[] objects10 = new Object[]{555, 666, 777, 888, 999};
        Object[] objects11 = new Object[]{0, 777, 666};
        Object[] objects12 = new Object[]{777, 666};
        MyCollection collection11 = new MyCollection(objects10);
        MyCollection collection12 = new MyCollection(objects11);
        MyCollection collection13 = new MyCollection(objects12);
        System.out.println(collection11.containsAll(collection12));
        System.out.println(collection11.containsAll(collection13));
        endBlockTest();
    }

    private void startBlockTest(String message) {
        printMessage(message);
    }

    private void endBlockTest() {
        printMessage("test ended");
    }

    private void printMessage(String message) {
        System.out.print("------------ ");
        System.out.print(message);
        System.out.println(" ------------");
    }
}
