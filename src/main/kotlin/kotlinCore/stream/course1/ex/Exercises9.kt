package kotlinCore.stream.course1.ex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Exercises9 {
    //reduce

    @Test
    fun reduce() {
        val integers = listOf(1, 2, 3, 4, 99, 100, 121, 1302, 199)
        val reduce = integers.reduce { a, b -> a + b }

        assertEquals(1831, reduce)

    }

    @Test
    fun reduce2() {
        val integers = listOf(1, 2, 3, 4, 99, 100, 121, 1302, 199)
        val reduce = integers.fold(0) { a, b -> a + b }

        assertEquals(1831, reduce)

    }

    @Test
    fun name() {

        val numbers: List<Int> = listOf(1, 2, 3)

        val (even, odd) = numbers.fold(Pair(mutableListOf<Int>(), mutableListOf<Int>())) { eoPair, number ->
            eoPair.apply {
                when (number % 2) {
                    0 -> first += number
                    else -> second += number
                }
            }
        }

        assertEquals(listOf(2), even)
        assertEquals(listOf(1, 3), odd)
    }
}