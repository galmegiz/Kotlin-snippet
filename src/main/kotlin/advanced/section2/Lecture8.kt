package advanced.section2

import kotlin.reflect.KProperty

/**
 * lateinit 변수는 컴파일 단계에서 nullable변수로 바뀌고 변수에 접근하려 할 때 null이면 예외 발생
 *
 * 값을 가져오는 비용이 크고 해당 변수가 사용되지 않을 수도 있다면 초기화 로직을 1회만 실행시키고 싶을 수 있다
 * lateinit -> 초기화 지연, 초기화는 어디서든 일어날 수 있다, 초기화 없이 호출하면 예외 발생
 * by lazy -> get() 호출 전으로 지연시킨 변수, 초기화 로직은 한 곳에만 존재
 *
 * 위임 패턴
 * -> Person getter()호출 -> DelegateProperty getter() 위임
 *
 * 코틀린의 by는 프로퍼티의 getter()와 Lazy의 객체를 getter()를 연결해줌
 */
fun main() {

}
class Lecture8 {
}

class Person{
    lateinit var name: String
    // lateinit var age: Int -> 불가, Int -> int, Int? -> Integer로 변경되기 때문
    val isKim: Boolean
        get() = this.name.startsWith("김")
    val maskingName: String
        get() = name[0] + (1..<name.length).joinToString(""){"*"}
}

class Person2{
    // backing property
    private var _name: String? = null
    val name: String
        get() {
            if (_name == null) {
                Thread.sleep(2000)
                this._name = "선"
            }
            return this._name!!
        }
}

class Person3{
    val name: String by lazy{
        Thread.sleep(2000)
        "선"
    }
}

class Person4{
    private val delegateProperty = LazyInitProperty{
     Thread.sleep(1000)
     "aaa"
    }

    val name: String
        get() = delegateProperty.value
}

class LazyInitProperty<T>(val init: () -> T){
    private var _value: T? = null
    val value: T
        get() {
            if (_value == null) {
                this._value = init()
            }
            return _value!!
        }


    operator fun getValue(thisRef: Any, property: KProperty<*>): T{
        return value
    }
}
