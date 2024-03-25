package advanced.section1

class GenericCage4<T : Fish> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T{
        return animals.first()
    }

    fun getAll(): List<T> {
        return animals
    }
}