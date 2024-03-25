import org.junit.jupiter.api.Test

class IntegerTest {

    @Test
    fun test() {
        val integer1 = Integer.valueOf(100)
        val integer2 = Integer.valueOf(100)
        // true
        println("integer1 === integer2 : ${integer1 === integer2}")

        val integer3 = Integer(100)
        val integer4 = Integer(100)
        // false
        println("integer3 === integer4 : ${integer3 === integer4}")

        val integer5 = Integer.valueOf(200)
        val integer6 = Integer.valueOf(200)
        // false
        println("integer5 === integer6 : ${integer5 === integer6}")

        val string1 = "abc"
        val string2 = "abc"
        // true
        println("string1 === string2 : ${string1 === string2}")

        val string3 = java.lang.String("abc")
        val string4 = java.lang.String("abc")
        // false
        println("string3 === string4 : ${string3 === string4}")
    }

}