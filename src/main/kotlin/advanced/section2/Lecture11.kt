package advanced.section2

import java.lang.IllegalArgumentException
import kotlin.properties.Delegates
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * 코틀린에서의 지연과 위임객체, 위임클래스에 대해 다룬다
 * 위임 객체를 만들려면 getValue(), setValue()가 있어야 한다
 *
 */
class Lecture11 {
}
class Person6{
    val name by DelegateProvider("선종우")
    val county by DelegateProvider("한국")

}

class DelegateProvider(
    private val initValue: String
) : PropertyDelegateProvider<Any, DelegateProperty>{
    override operator fun provideDelegate(thisRef: Any, property: KProperty<*>): DelegateProperty{
        if (property.name != "name") {
            throw IllegalArgumentException("네임만 여냐결 가능")
        }
        return DelegateProperty(initValue)
    }
}


class DelegateProperty(
    private val initValue: String
) : ReadOnlyProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return initValue
    }
}

interface Fruit{
    val name: String
    val color: String
    fun bite()
}

open class Apple : Fruit{
    override val name: String
        get() = "사과"
    override val color: String
        get() = "빨간색"

    override fun bite() {
        print("사과")
    }
}

class GreenApple : Fruit{
    override val name: String
        get() = "사과"
    override val color: String
        get() = "초록색"

    override fun bite() {
        print("사과")
    }
}

// Apple을 open해야 함
open class GreenApple2 : Apple(){
    override val color: String
        get() = "초록색"

}

// 코드 양 증가
class GreenApple3(
    private val apple: Apple
) : Fruit{
    override val name: String
        get() = apple.name
    override val color: String
        get() = "초록색"

    override fun bite() = apple.bite()
}

// 클래스 위임
class GreenApple4(
    private val apple: Apple
) : Fruit by apple{
    override val color: String
        get() = "초록색"
}