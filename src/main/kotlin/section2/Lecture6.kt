package section2

/**
 * 반복문에 대해서 다룬다
 */
fun main() {
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println(number)
    }

    // 1 -> 2 -> 3
    for (i in 1..3) {
        println(i)
    }

    // 1 -> 2
    for (i in 1..<3) {
        println(i)
    }

    // 1 -> 2
    for (i in 1 until 3) {
        println(i)
    }

    // 3 -> 2 -> 1
    for (i in 3 downTo 1) {
        println(i)
    }

    // 1 -> 3 -> 5
    for (i in 1..5 step 2) {
        println(i)
    }

    // while, do-while은 java와 동일
    var i = 1
    while (i <= 3) {
        println(i)
        i++
    }

    do {
        println(i--)
    } while (i > 0)
}