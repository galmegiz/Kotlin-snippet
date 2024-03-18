package section1

import section1.Lecture2.Person

/**
 * kotlin nullable에 대한 설명을 다룬다
 */
fun main() {
    val str: String? = "ABC"
    println(str ?. length) // null이 아닌 경우에만 length실행, Optional의 ifPresent()와 유사
    println(str ?: 0) // null인 경우 연산자 뒤의 값 반환, Optinal의 orElse(), orElseGet()과 유사
    println(str !!. length) // nullable타입인데 null이 아님을 확신할 수 있는 경우, JPA사용 시 id값 등

    val person = Person("선종우")
    // 플랫폼 타입 : 다른 프로그래밍 언어에서 전달되어 nullable여부를 판단할 수 없는 타입
    val nullableName: String? = person.nullableName // 자바의 nullable 반환값을 이용 시 nullabe타입으로 인식한다
    val name: String/*플랫폼 타입*/ = person.name // null이 가능한 String임에도 코틀린에서는 String 타입으로 인식한다

}

/**
 * String과 String?은 다른 자료형으로 취급된다
 */
fun startWithA(str: String): Boolean {
    return str.startsWith("A")
}

fun startWithA1(str: String?): Boolean {
    if (str == null) {
        throw IllegalArgumentException()
    }

    return str.startsWith("A")
}

fun startWithA1ver2(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException()
}

fun startWithA2(str: String?): Boolean? {
    if (str == null) {
        return null
    }

    return str.startsWith("A")
}

fun startWithA2ver2(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startWithA3(str: String?): Boolean {
    if (str == null) {
        return false
    }

    return str.startsWith("A")
}

fun startWithA3ver3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}
