package advanced.section2

import kotlin.properties.Delegates.notNull
import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

/**
 * kotlin에서 사용하는 다양한 지연객체에 대해 다룬다
 */
fun main() {

}

class Lecture10 {
}

class Person5(map: Map<String, Any>){
    var age: Int by notNull() // lateInit과 유사한 방법
    var age2: Int by observable(20){ _, oldValue, newValue ->
        println("옜날 값 : $oldValue / 새로운 값 : $newValue")
    }
    var age3: Int by vetoable(20) { _, _, newValue -> newValue >= 1}

    var age4: Int by this::age // 또다른 프로퍼티로 위임

    val name: String by map // getter가 호출되면 map["name"]을 찾는다
    // MutableMap을 사용하면 set도 가능
}