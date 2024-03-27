package advanced.section3

/**
 * 고차함수로 인해 발생하는 오버헤드를 줄이는 방법 : inline
 */
class Lecture15 {
}

inline fun repeat(times: Int, /*noinline*/exec: () -> Unit) {
    for (i in 1..times) {
        exec()
    }
}

/**
 * repeat과 함께 print함수까지 inline한다
 * -> inline은 자기 자신뿐만 아니라 매개변수도 inlining한다
 * inline을 사용하게 되면 람다 안에 return을 사용할 수 있다(non local return이 가능하다)
 *
 * noinline하면 매개변수는 인라이닝 하지 않는다
 *
 * crossinline을 사용하면 non-local return이 불가능해진다
 *
 * inline프로퍼티 -> 프로퍼티가 코드 안에 인라이닝 됨
 */
fun main() {
    repeat(2) { print("Helloworld") }
}

// 아래의 경우 매개변수의 내용을 알 수 없으므로 매개변수는 inling되지 않는다
fun main2(exec: () -> Unit) {
    repeat(2, exec)
}