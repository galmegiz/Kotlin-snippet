package advanced.section1

class GenericCage<T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T{
        return animals.first()
    }

    fun put(animal: T){
        this.animals.add(animal)
    }

    fun moveFrom(cage: GenericCage<T>){
        this.animals.addAll(cage.animals)
    }
}