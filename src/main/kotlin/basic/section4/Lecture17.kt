package basic.section4

/**
 * Java에서는 함수형 인터페이스를 이용해 함수를 인자로 넘겨주는 것처럼 쓸 수 있다
 * 그렇다고 변수에 함수를 할당하거나 파라미터로 전달할 수는 없는 2급시민으로 취급된다
 *
 * 코틀린에서는 함수가 그 자체로 값이 될 수 있다(1급 시민), 변수에 할당할 수도 변수로 넘길 수도 있다
 *
 * java에서는 람다 밖의 변수를 사용할 때 제약이 있다 -> 코틀린은 상관 없다(클로저)
 * 코틀린은 람다가 시작하는 지점에 참고하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있는다.
 * 이 데이터 구조를 Closure라고 부른다
 */
fun main() {

    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    filterFruits(emptyList(), isApple)
    filterFruits(emptyList()){ a -> a.name == "사과"}
    filterFruits(emptyList()){ it.name == "사과"}

}

private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter.invoke(fruit)) {
            results.add(fruit)
        }
    }

    return results
}

class Lecture17 {

}

class Fruit(
    val name: String,
    val price: Int
)