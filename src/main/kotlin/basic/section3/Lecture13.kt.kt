package basic.section3

fun main() {

}
/**
 * 중첩 클래스에 대해 다룬다
 */
class Lecture13 {

}

// 코트린에서는 기본적으로 outer class의 객체를 직접 참조하지 않는 않는 inner class가 생성된다
class House(
    var address: String,
    var livingRoom: LivingRoom
){
    class LivingRoom(
        private var area: Double
    )

    // 바깥 클래스 참조가 필요한 경우 inner 키워드를 명시한다
    inner class LivingRoom2(
        private val area: Double
    ){
        val address: String
            // outer class 객체를 참조할 때는 @를 사용해야 한다
            get() = this@House.address
    }

}