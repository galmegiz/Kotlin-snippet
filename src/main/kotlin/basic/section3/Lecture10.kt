package basic.section3

fun main(){
    /**
     * 출력 결과 0이 나온다
     * super() -> getNumber호출 -> getNumber는 Derived의 this.number 반환(number는 아직 초기화되지 않은 상태) -> Derived()호출되며 number 초기화됨
     * 상위 클래스의 생성자 또는 초기화 블록에서 open이 붙은 프로퍼티를 사용하면 얘기치 못한 버그가 생길 수 있음
     */
    val class1 = Lecture10.Derived(120)
}
/**
 * 상속과 인터페이스에 대해 다룬다
 */
class Lecture10 {

    class KotlinCat(species: String, override val swimAbility: Int) : basic.section3.JavaAnimal(species, 4), Swimable, Flyable {

        override fun move() {
            println("move cat")
        }

        override fun act() {
            super<Swimable>.act()
            super<Flyable>.act()
        }
    }

    interface Swimable{
        // 필드가 아닌 getter이기 때문에 interface에 필드와 같은 것을 선언할 수 있다
        val swimAbility: Int
        fun act(){
            println("swim")
        }
    }

    interface Flyable{
        fun act(){
            println("fly")
        }
    }


    open class Base(
        open val number: Int = 100
    ) {
      init {
          println("Base class")
          println(number)
      }
    }

    class Derived(
        override val number: Int
    ) : Base(number) {
        init {
            println("Derived class")
        }
    }


}