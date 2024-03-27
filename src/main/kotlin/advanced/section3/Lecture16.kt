package advanced.section3

import advanced.section2.Person
import java.util.function.Predicate

/**
 * SAM에 대해 다룬다
 * SAM : Single Abstract Method
 * 자바에서는 SAM 인터페이스(함수형 인터페이스)를 람다로 인스턴스화할 수 있다
 *
 * 코틀린은 람다식을 이용해 바로 인스턴스화를 하는 게 불가능하다
 *
 * Java에서는 호출 가능 참조 결과값이 Consumer / Supplier같은 함수형 인터페이스이지만
 * Kotlin에서는 reflection 객체이다
 */
class Lecture16 {
}
fun add3(a: Int, b: Int) = a + b
fun main() {
    // val filter: Predicate<String> = { s -> s.startsWith("A") }  -> 자바에서는 람다를 이용해 인스턴스화 가능
    val filter: Predicate<String> = Predicate { s -> s.startsWith("A")}

    // 매개변수로 사용할 경우는 SAM 생성자를 생략할 수 있다
    // SAM 인스턴스가 Predicate, StringFilter 두 개 모두로 인스턴스화 가능, 이 경우 더 구체적인 StringFilter로 사용된다
    // 암시적인 인스턴스화의 경우 의도하지 않은 SAM이 호출될 수 있다
    consumeFilter({ s: String -> s.startsWith("A")})

    val add3 = ::add3 // 메소드 참조(callable reference)
    val classRef = ::Person // 클래스 생성자에 대한 참조
    val geterRef = Person::name.getter // 프로퍼티에 대한 참조
    val p1 = Person()
    val instanceRef = p1::name.getter // 인스턴스를 이용해 참조
}

fun <T> consumeFilter(filter: Predicate<T>) { }
fun consumeFilter(filter: StringFilter) {}

public interface  StringFilter{
    abstract fun predicate(str: String): Boolean
}