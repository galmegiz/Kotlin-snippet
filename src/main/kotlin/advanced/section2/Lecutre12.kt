package advanced.section2

/**
 * 대용량 데이터에 대해서 sequence를 사용하면 모든 collection에 대해 연산을 수행하지 않을 수 있다
 * 데이터 숫자가 작을 때는 iterable이 더 빠르다
 */
fun main() {
    val fruits = listOf(
        MyFruit("사과", 1000),
        MyFruit("바나나", 3000)

    )

    val avg = fruits.asSequence()
        .filter { it.name == "사과" }
        .map{ it.price }
        .take(10_000)
        .average()

}

class Lecutre12 {
}

data class MyFruit(
    val name: String,
    val price: Long
)