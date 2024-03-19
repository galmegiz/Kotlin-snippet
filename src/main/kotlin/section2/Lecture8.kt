package section2

/**
 * 코틀린의 기본 함수 문법에 대해 다룬다
 * 함수는 클래스 안에 있을 수도, 파일 최상단에 있을 수도, 한 파일 안에 여러 함수가 있을 수도 있다
 */
fun main() {
    repeat("Hello world", 1)
    // num에는 자동으로 3이 들어간다, useNewLine은 named argument라고 한다
    repeat("Helo", useNewLine = true)
    // 자바함수를 가져 올 때는 named argument를 사용할 수 없다

    val params = arrayOf("a", "b")
    // 가변인자 매개변수에 배열을 넣을 때는 *(스프레드 연산자)를 사용한다
    printAll(*params)
    printAll("a", "b")
}

// body가 하나의 값으로 간주되는 경우  block을 없앨 수도 있고 block이 없ㄷ아면 반환 타입을 없앨 수도 있다
fun max(a: Int, b: Int): Int =
    if (a > b) {
        a
    } else {
        b
    }

fun max2(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

// =을 사용하는 경우 반환값을 명시하지 않아도 된다
fun max3(a: Int, b: Int) = if (a > b) a else b

// default parameter를 사용해 overloading을 대신할 수도 있다 -> 함수 호출 시 매개변수를 전달하지 않으면 default parameter가 입력됨
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

// 가변인자 함수에는 vararg를 사용해야 한다
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }

}

