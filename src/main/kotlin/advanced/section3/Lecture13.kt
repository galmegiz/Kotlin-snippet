package advanced.section3

/**
 * 고차함수에 대해 다룬다
 * 고차함수 : 함수를  매개변수나 반환값으로 사용하는 것
 * 함수값/함수리터럴 : 일반 함수와 달리 변수로 간주하거나 파라미터에 넣을 수 있는 함ㅅ
 * 람다 : 이름이 없는 함수
 *
 * 람다식 : (코틀린) 함숫값/함수 리터럴을 표현하는 방법 1
 * 익명함수 : 함수값/함수리터럴을 표현하는 방법 2
 *
 * 람다 내에서는 return 불가 return은 가장 가까운 함수를 return시키기 때문(non-local return)
 */

fun main() {
    compute(5, 3) {a, b -> a + b} // 람다식
    compute(5, 3, fun(a: Int, b: Int) = a + b) // 익명함수
}
class Lecture13 {

}


fun compute(num1: Int, num2: Int, op: (Int, Int) -> Int): Int {
    return op(num1, num2)
}

fun calculate(num1: Int, num2: Int, op: Operator) = op.calcFun(num1, num2)

enum class Operator(
    private val oper: Char,
    val calcFun: (Int, Int) -> Int,
){
    PLUS('+', { a, b -> a + b}),
    MINUS('-', { a, b -> a - b}),
    MULTIPLY('*', { a, b -> a * b}),
    DIVIDE('/', {a, b, -> a / b})
}