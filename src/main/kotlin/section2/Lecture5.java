package section2;

public class Lecture5 {

    public void validateScoreIsNotNegative(int score) {
        if (score < 0) {
            throw new IllegalArgumentException();
        }
    }

    public String getPassOrFail(int score) {
        if (score >= 50) {
            return "P";
        } else {
            return "F";
        }

        // -> 위 statement는 삼항연산자로 대체 가능 return score >= 50 ? "P" : "F";
    }

    public String getGradeWithSwitch(int score) {
        switch (score / 10) {
            case 0:
                return "A";
            case 8:
                return "B";
            default:
                return "D";
        }
    }
}
