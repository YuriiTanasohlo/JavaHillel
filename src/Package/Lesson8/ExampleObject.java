package Package.Lesson8;


import java.util.Objects;

public class ExampleObject {
    private final String myString;

    public ExampleObject(String myString) {
        this.myString = myString;
    }

    public String getMyString() {
        return myString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExampleObject that = (ExampleObject) o;

        return Objects.equals(myString, that.myString);
    }

    @Override
    public String toString() {
        return myString;
    }
}
