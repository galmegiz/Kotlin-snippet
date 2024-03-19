package section2

/**
 * if-else, switch문에 대한 설명
 */
fun main() {

}

// 점수가 음수이면 예외를 던진다
fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException()
    }
}

// 점수가 0 ~ 100 점사이가 아니면 예외를 던진다
fun validateScore(score: Int) {
    if (score !in 0..100) {
        throw IllegalArgumentException()
    }
}

// Java에서 if-else는 statement지만 kotlin에서는 if-else문을 expression으로 취급한다
fun getPassOrFail(score: Int): String {
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

fun getGradeWithSwitch(score: Int): String{
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        else -> "D"
    }
}

fun getGradeWithSwitch2(score: Int): String {
    val case1 = when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        else -> "D"
    }

    // instanceOf 대신에 is를 사용할 수 있다. is 구문 뒤에서는 스마트캐스트가 일어난다
    var variable: Any = Object()
    val case2 = when (variable) {
        is String -> variable.startsWith("A")
        is Int -> variable.toString()
        else -> throw IllegalArgumentException()
    }

    // 조건을 ,로 나열할 수 있다
    when (score) {
        1, 0, -1 -> println("0 또는 1입니다")
        else -> throw IllegalArgumentException()
    }


    //when에 변수를 생략할 수 있다
    when {
        score == 0 -> println("0입니다")
        score % 2 == 0 -> println("짝수입니다")
        else -> throw IllegalArgumentException()
    }

    return "a"
}