package advanced.section1

class GenericCage2<T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T{
        return animals.first()
    }

    fun put(animal: T){
        this.animals.add(animal)
    }

    // 해당 함수 파라미터에 대해서는 변성이 적용된다
    fun moveFrom(cage: GenericCage2<out T>){
        this.animals.addAll(cage.animals)
    }

    // Generic<GoldFish>의 하위 타입인 Generic<Fish>타입이 들어올 수 있게 된다(반공변)
    // use-site variance
    fun moveTo(otherCage: GenericCage2<in T>) {
        otherCage.animals.addAll(this.animals)
    }
}