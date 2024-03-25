package basic.section4

/**
 * 코틀린의 컬렉션에 대해 다룬다
 */
fun main() {
    val array = arrayOf(100, 200)
    for (i in array.indices) {
        println("${array[i]}")
    }
    array.plus(101)
    for((idx, value) in array.withIndex()){
        println("${idx} ${value}")
    }

    val numbers = listOf(100, 200)
    val mutableNumbers = mutableListOf(100, 200)
    val emptyList = emptyList<Int>()


    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "Monday"
    oldMap[2] = "Tuesday"

    val newMap = mapOf(1 to "Monday", 2 to "TuesDay")

    val list: List<Int?>
    val list2: List<Int>?
    val list3: List<Int?>?

    // kotlin -> java : java에서는 불변, non-null 개념이 없다
    // 따라서 java에서 코틀린 코드를 사용할 때는 에러가 발생할 수 있다
}

class Lecture15 {

}