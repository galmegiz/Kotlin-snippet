package basic.section1

/**
 * 연산자에 대해 다룬다.
 * 코틀린의 연산자는 자바와 거의 같다
 * 코틀린 전용 연산자 in / !in, a..b(a~b범위의 객체 생성), a[i] : a에서 특정 index의 값을 가져옴
 * 연산자 오버로딩 : 객체마다 연산자를 재정의할 수 있다
 */
fun main() {
    val money1 = Money(10)
    val money2 = Money(20)
    println(money1 > money2) // 객체에 대해 비교 연산자 사용 시 자동으로 compareTo를 호출한다
    val money3 = Money(10)

    println(money1 === money3) // false -> 동일성 비교 결과
    println(money1 == money3) // true -> 동등성 비교 결과(eqauls)

    println(money1 + money2) // 연산자 오버로딩
}

class Money(val money: Int) : Comparable<Money> {

    // 덧셈 연산을 정의한다
    operator fun plus(money: Money): Money {
        return Money(this.money + money.money)
    }

    override fun compareTo(other: Money): Int {
        return compareTo(other)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        return money == other.money
    }

    override fun hashCode(): Int {
        return money
    }
}