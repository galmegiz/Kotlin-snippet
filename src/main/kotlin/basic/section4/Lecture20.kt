package basic.section4

/**
 * scope function
 * let -> 함수를 받아서 함수의 결과를 반환(람다의 결과 반환), T를 매개변수로 갖는 일반함수를 받는다.
 * run -> 람다의 결과 반환, T에 대한 확장함수를 받는다.
 * also -> 객체 자체 반환
 * apply -> 객체 자체 반환
 * with -> 변수를 this로 접근해 함수 실행
 *
 * scope function은 일시적인 영역을 만들어 코드를 더 간결하게 하건, method chain에 활용된다
 */
fun main() {

}

class Lecture20 {

}

fun printPerson(person: Person?) {
    person?.let{
        println(it.age)
        println(it.name)
    }
    person?.run{
        println(this.name)

    }
}