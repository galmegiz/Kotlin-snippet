package advanced.section1

class GenericCage5<T> where T: Animal, T : Comparable<T> {
    private val animals: MutableList<T> = mutableListOf()

    fun printAfterSorting() {
        animals.sorted()
            .map{it.name}
            .let(::println)
    }

    fun getFirst(): T{
        return animals.first()
    }

    fun getAll(): List<T> {
        return animals
    }
}