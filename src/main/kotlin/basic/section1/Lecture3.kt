package basic.section1

import basic.section1.Lecture3.Person

/**
 * 코틀린 타입 및 형변환에 대해 다룬다
 *
 * Object -> Any
 * void -> Unit(FP에서 단 하나의 인스턴스만 갖는 타입을 의미)
 * X -> Nothing(함수가 정상적으로 끝나지 않았다는 사실을 표현)
 */
fun main() {
    var number1 = 10 // int
    var number2 = 10L // long
    var number3 = 10f // float
    var number4 = 10.0 // double

    number2 = number1.toLong() // 명시적으로 형변환을 해줘야 한다, 자바의 암시적 형변환 지원하지 않음
}

fun printAgeIfPerson(obj: Any) {
    if (obj is basic.section1.Lecture3.Person) {
        val person = obj as Person // as Person 생략 가능
        println(person.age)
    }

    if (obj !is basic.section1.Lecture3.Person) {
        println("사람 아님")
    }

    // 위의 전체와 같음
    println((obj as? Person)?.age ?: "사람 아님")
}

