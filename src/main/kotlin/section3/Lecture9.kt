package section3


/**
 * 코틀린 클래스에 대해 다룬다
 */
fun main() {
    val person = Person("쫑", 10)
    println(person.name)
    person.age = 29

    /*val javaPerson = JavaPerson("쫑2", 20)
    println(javaPerson.name)
    javaPerson.age = 29*/

    val person2 = Person("쫑3")

    //생성자 호출 순서 : 초기화 블록 -> 부생성자1 -> 부생성자2
    val person3 = Person()
    person.isAdult
    person.isAdultFunction()

    val person4 = Person2("sun")
    println(person4.getNameFunction())
}

// 기본 클래스 문법
// 클래스 옆 생성자 -> primary constructor(주생성자)
// body에 있는 생성자 -> secondary constructor(부생성자), 해당 생성자는 반드시 주생성자를 호출해야 한다
// 생성자 호출 순서는 주생성자(초기화 블록) -> 부생성자1 -> 부생성자2
public class Person constructor(name: String, age: Int) {
    var age: Int = age // 코틀린에서는 자동으로 getter, setter를 만들어 준다

    // field는 backing field라고 부른다
    // name.uppercase()가 아닌 field.uppercase()를 사용해야 한다
    var name: String = name
        get() = field.uppercase()
        set(value) { field = value }
    // backing field를 사용하지 않고도 아래와 같이 만들 수 있따
    val upperCaseName: String
        get() = this.name.uppercase()

    // 커스텀 getter를 구현할 수 있다
    val isAdult: Boolean
        get() = this.age >= 20

    // 생성자 호출시 무조건 호출되는 초기화 블록
    init{
        if (age < 0) {
            throw IllegalArgumentException()
        }
    }

    // 부생성자 -> 생성자 오버로딩
    // body를 가질 수 있다
    // 부생성자보다는 정적 팩터리 메서드를 구현하는 걸 추천
    constructor(name: String): this(name, 1){
        println("부생성자1")
    }

    constructor() : this("쫑"){
        println("부생성자2")
    }

    fun isAdultFunction(): Boolean {
        return this.age >= 10
    }
}

// 축약버전
class Person2(
    name: String,
    var age: Int = 10
) {
    val name = name
        get() = field.uppercase()

    // this.name으로 접근하더라도 getter를 통해 접근한다
    fun getNameFunction(): String {
        return this.name
    }
}

