package section1;

public class Lecture3 {
    public static void printAgeIfPerson(Object object) {
        if (object instanceof Lecture2.Person) {
            Person person = (Person) object;
            System.out.println("person.age = " + person.age);
        }
    }

    public static class Person{
        int age;
    }
}
