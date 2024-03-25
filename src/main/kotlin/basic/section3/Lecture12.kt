package basic.section3

fun main() {

}

/**
 * companion object, object, 일명 클래스에 대해 다룬다
 */
class Lecture12 {

}


class Lec12Person private constructor(
    var name: String,
    var age: Int,
    val task: Runnable
){
    // 클래스와 동행하는 유일한 object
    companion object Factory/*이름을 붙일 수도 있다*/ : Runnable{

        const val MIN_AGE = 1 // compile 시 할당
        val MIN_AGE2 = 2 // runtime 시 할당

        // 익명클래스 사용법
        fun newBaby(name: String): Lec12Person {
            return Lec12Person(name, MIN_AGE, object : Runnable{
                override fun run() {
                    TODO("Not yet implemented")
                }
            })
        }

        // java static과 동일한 방식으로 사용 가능
        @JvmStatic
        fun newBaby2(name: String): Lec12Person {
            return Lec12Person(name, MIN_AGE2, object : Runnable{
                override fun run() {
                    TODO("Not yet implemented")
                }
            })
        }

        // 인터페이스를 구현할 수도 있다
        override fun run() {
            TODO("Not yet implemented")
        }
    }
}

object SingleTon {
    val a: Int = 0
}
