package section1;

import org.jetbrains.annotations.Nullable;

public class Lecture2 {
    public boolean startWithA1(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        return str.startsWith("A");
    }

    public Boolean startWithA2(String str) {
        if (str == null) {
            return null;
        }

        return str.startsWith("A");
    }

    public boolean startWithA3(String str) {
        if (str == null) {
            return false;
        }

        return str.startsWith("A");
    }

    public static class Person {
        private final String nullableName;
        private final String name;

        public Person(String name) {
            this.name = name;
            this.nullableName = name;
        }

        public String getName() {
            return name;
        }

        @Nullable
        public String getNullableName() {
            return nullableName;
        }
    }
}
