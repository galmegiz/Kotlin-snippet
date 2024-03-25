package basic.section3;

public class JavaLec12Person {
    private static final int MIN_AGE = 1;

    public static JavaPerson newBaby(String name) {
        return new JavaPerson(name, MIN_AGE);
    }

    private String name;
    private int age;

    public JavaLec12Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
