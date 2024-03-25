package basic.section4

class Lecture18 {
    val fruitsInList: List<List<Fruit2>> = listOf(
        listOf(
            Fruit2(100, 200),
            Fruit2(100, 200),
        ),
        listOf(
            Fruit2(100, 200),
            Fruit2(100, 200),
        ),
        listOf(
            Fruit2(100, 200),
            Fruit2(100, 200),
        )
    )

    fun test() {
        val flattenLst: List<Fruit2> = fruitsInList.flatten()
        val lst: List<Fruit2> = fruitsInList.flatMap { list -> list.filter{fruit -> fruit.factoryPrice == fruit.currentPrice} }
    }
}



class Fruit2(
    val factoryPrice: Int,
    val currentPrice: Int
)

