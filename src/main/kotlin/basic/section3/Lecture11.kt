package basic.section3

private val NUM = 3

internal fun add(a: Int, b: Int): Int {
    return a + b
}

/**
 * 접근제어자에 대해 다룬다
 */
class Lecture11 {

    private val a: Int = 10
    protected val b: Int = 10
    internal val c: Int = 10
    public val d: Int = 10
}