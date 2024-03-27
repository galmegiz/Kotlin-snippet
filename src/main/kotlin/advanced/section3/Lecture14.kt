package advanced.section3

/**
 * 확장함수의 타입
 * 고차함수를 사용하게 되면 FunctionN클래스가 만들어지고 인스턴스화 되어야 하므로 오버헤드가 발생할 수 있다
 * 함수에서 변수를 폭회할 경우 해당 변수를 Ref라는 객체로 감싸야 한다. 때문에 오버헤드가 발생할 수 있다
 *
 * 고차함수를 반복문 안에서 사용하는 것은 자제하는 게 좋다
 */
class Lecture14 {

}
// 확장함수의 타입

fun Int.add(other: Long): Int = this + other.toInt()

// Int.(Long) -> Int
val add2 = fun Int.(other: Long): Int = this + other.toInt()

fun main() {
    // 확장함수의 호출 방법
    add2.invoke(5, 3L)
    add2(4, 3L)
    5.add2(3L)


    var num = 5
    num += 1
    // 클로저 개념이 들어갈 경우 num은 Reference타입이 되어 람다 안에서는 해당 객체 내부의 값을 수정한다
    val plusOne: () -> Unit = { num += 1 }
}



fun compute2(num1: Int, num2: Int, op: (Int, Int) -> Int): Int{
    return op(num1, num2)
}
