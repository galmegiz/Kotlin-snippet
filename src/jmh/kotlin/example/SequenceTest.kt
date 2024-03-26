package example

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import java.util.concurrent.TimeUnit
import kotlin.random.Random
import kotlin.time.measureTime

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
class SequenceTest {
    private val fruits = mutableListOf<Fruit>()

    @Setup
    fun init() {
        (1..2_000_000).forEach{ _ -> fruits.add(Fruit.random())}
    }

    @Benchmark
    fun kotlinSequence() {
        val avg = fruits.asSequence()
            .filter{it.name == "사과"}
            .map{it.price}
            .take(10_000)
            .average()
    }

    @Benchmark
    fun kotlinIterator() {
        val avg = fruits
            .filter{it.name == "사과"}
            .map{it.price}
            .take(10_000)
            .average()
    }

    @Benchmark
    fun kotlinMeasureTIme() {
        val time = measureTime { fruits
            .filter{it.name == "사과"}
            .map{it.price}
            .take(10_000)
            .average()
        }

    }
}


data class Fruit(
    val name: String,
    val price: Long
){
    companion object {
        private val NAME_CANDIDATES = listOf("사과", "바나나", "수박", "체리")
        fun random(): Fruit{
            val randNum1 = Random.nextInt(0, 4)
            val randNum2 = Random.nextLong(1000, 20001)
            return Fruit(
                name = NAME_CANDIDATES[randNum1],
                price = randNum2
            )
        }


    }
}