package Package.Lesson13;

import java.util.Comparator;

public class IntComparator implements Comparator {
    @Override
    public int compare(Object object1, Object object2) {
        return Integer.compare((int)object1, (int)object2);
    }
}
