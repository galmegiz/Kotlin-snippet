package advanced.section4

import java.time.LocalDate

/**
 * 연산자 오버로딩에 대해 다룬다
 */
class Lecture17 {
}

fun main() {
    val point = Point(20, -10)
    println(-point)

    LocalDate.now() + Days(3)
    LocalDate.now() + 3.days // 활장 프로퍼티
}

data class Point(
    val x: Int,
    val y: Int
){
    fun zeroPointSymmetry(): Point = Point(-x, -y)

    operator fun unaryMinus(): Point{
        return Point(-x, -y)
    }
}

data class Days(val day: Long)

val Int.days: Days
    get() = Days(this.toLong())

operator fun LocalDate.plus(days: Days): LocalDate {
    return this.plusDays(days.day)
}

fun calculate(num1: Int, num2: Int, op: Operator) = op.calcFun(num1, num2)
fun calculate2(num1: Int, num2: Int, op: Operator) = op(num1, num2)
enum class Operator(
    private val oper: Char,
    val calcFun: (Int, Int) -> Int,
){
    PLUS('+', { a, b -> a + b}),
    MINUS('-', { a, b -> a - b}),
    MULTIPLY('*', { a, b -> a * b}),
    DIVIDE('/', {a, b, -> a / b});

    operator fun invoke(num1: Int, num2: Int): Int {
        return this.calcFun(num1, num2)
    }
}