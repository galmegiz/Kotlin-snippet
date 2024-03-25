package advanced.section1

// 데이터를 생산만 하는 경우 클래스 자체를 공변하게 바꿀 수 있다
// declaration-site variance, 자바에서는 지원하지 않음
// Comparable 인터페이스, List 인터페이스
class GenericCage3<out T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T{
        return animals.first()
    }

    fun getAll(): List<T> {
        return animals
    }
}