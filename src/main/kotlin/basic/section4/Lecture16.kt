package basic.section4


/**
 * 코틀린에서 다양한 함수를 다루는 방법을 설명한다
 * Java 코드가 있는 상황에서 Kotlin 코드로 추가 기능 개발을 하기 위해 확장함수와 확장프로퍼티가 등장
 * 확장함수와 멤버함수의 시그니처가 동일하면 멤버함수를 우선 호출한다 -> 멤버함수, 확장함수 중 멤버함수에 우선권이 있다
 * 확장함수는 원본 클래스의 private, protected 멤버 접근 불가
 */
fun main() {
    val train: Train = Train()
    val srt1: Train = Srt()
    srt1.isExpensive() // Train확장함수 호출
    val srt2: Srt = Srt()
    srt2.isExpensive() // Srt확장함수 호출

    3 add2 4

}

// String -> 수신객체 타입
fun String.lastChar(): Char{
    // this -> 수신 객체
    return this[this.length - 1]
}

class Lecture16 {

}

open class Train(
    val name: String = "새마을기차",
    val price: Int = 5000
)

fun Train.isExpensive(): Boolean{
    println("Train 확장함수")
    return this.price >= 10000
}

class Srt : Train("SRT", 40000)

fun Srt.isExpensive(): Boolean{
    println("Srt의 확장함수")
    return this.price >= 10000
}

val String.lastChar: Char
    get() = this[this.length - 1]

// infix 함수 -> 변수.함수이름(argument) 대신 변수 함수이름 argument를 허용한다
infix fun Int.add2(other: Int): Int {
    return this + other
}

// 함수 호출 오버헤드를 줄이기 위해 사용할 수 있으나 성능 측정과 함께 신중하게 사용되어야 한다
inline fun Int.add3(other: Int): Int {
    return this + other
}