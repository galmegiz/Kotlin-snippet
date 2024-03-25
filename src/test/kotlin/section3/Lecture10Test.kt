package section3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Lecture10Test{

    @Test
    fun catTest() {
        val cat = Lecture10.KotlinCat("cat", 4)
        println(cat.legCount)
    }
}
