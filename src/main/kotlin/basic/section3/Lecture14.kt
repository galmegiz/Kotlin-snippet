package basic.section3

/**
 * data, enum, sealed에 대해 다룬다
 */
fun main() {
    val dto1 = PersonDto("aa", 2)
    println(dto1)

    // enum을 이용한 분기처리
    val country: Country = Country.AMERICA
    when (country) {
        Country.AMERICA -> TODO()
        Country.KOREA -> TODO()
    }


}

// 하위 클래스가 when 절 안에 없을 경우 compile 오류 발생
private fun handleCar(car: HyundaiCar) {
    when(car){
        is Avante -> TODO()
        is Grandeur -> TODO()
        is Sonata -> TODO()
    }
}

class Lecture14 {

}

data class PersonDto(
    val name: String,
    val age: Int
)

enum class Country(private val code: String) {
    KOREA("KO"),
    AMERICA("US");
}

/**
 * 상속은 가능하지만 위부에서는 클래스에서의 상속을 막고싶을 때 사용
 * 컴파일 타입 때 하위 클래스의 타입을 모두 기억한다(런타임 때 클래스타입 추가 불가)
 * 하위 클래스는 같은 패키지에 있어야 하며, 멀티 인스턴스화할 수 있다
 */
sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class Avante : HyundaiCar("아반떼", 1_1000L)
class Sonata : HyundaiCar("아반떼", 1_1000L)
class Grandeur : HyundaiCar("아반떼", 1_1000L)