package basic.section4

typealias FruitFilter = (Fruit) -> Boolean
typealias USGTMap = Map<String, UltraSuperGuardianTribe>

data class UltraSuperGuardianTribe(val name: String)
// data 클래스는 componentN이라는 함수를 자동으로 만들어 준다
data class Person(val name: String, val age: Int)
class Person2(val name: String, val age: Int){
    operator fun component1(): String{
        return this.name
    }

    operator fun component2(): String{
        return this.name
    }
}

/**
 * 코틀린의 기타 기능들 구조분해, typealias, import as
 * return 기본적으로 가장 가까운 enclosing function 또는 익명함수로 값이 반환된다
 *
 * Jump와 label
 *
 *
 */
fun main() {

    fun filterFruits(fruits: List<Fruit>, filter: FruitFilter) {

    }

    val person = Person("선", 100)
    val (name, age) = person // 구조분해 문법은 compontN을 호출하는 것이다
    val name1 = person.component1()
    val age2 = person.component2()

    val (name3, age3) = Person2("Aa", 1002)

    loop@ for (i in 1..100) {
        for (j in 2..200) {
            if(j == 5)
                break@loop
        }
    }

    val number = 0
    number.takeIf { it > 10 } // 조건을 만족하면 number 그렇지 않으면 null 반환
}

class Lecture19 {

}