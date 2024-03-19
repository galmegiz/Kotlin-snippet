package section2;

public class Lecture8 {
    public static void main(String[] args) {
        String[] params = new String[]{"a", "b"};
        printAll(params);
    }
    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public void repeat(String str, int num, boolean useNewLine) {
        for (int i = 1; i <= num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.print(str);
            }
        }
    }

    // 오버로딩
    public void repeat(String str, int num) {
        repeat(str, num, true);
    }

    // 가변인자 함수
    public static void printAll(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
