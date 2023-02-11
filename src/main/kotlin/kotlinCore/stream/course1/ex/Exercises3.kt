package kotlinCore.stream.course1.ex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Exercises3 {

    @Test
    fun min() {
        val numbers = mutableListOf(1, 2, 3, 100, 23, 93, 99)
        val min = numbers.min()
        assertEquals(min, 1)
    }

    @Test
    fun max() {
        val numbers = mutableListOf(1, 2, 3, 100, 23, 93, 99)
        val max = numbers.max()
        assertEquals(max, 100)
    }

    @Test
    fun findMin() {
        val numbers = mutableListOf(1, 2, 3, 100, 23, 93, 99)

        val reduce = numbers.reduce { a: Int, b: Int -> a.coerceAtMost(b) }
        println(reduce)

    }

    @Test
    fun findMax() {
        val numbers = mutableListOf(1, 2, 3, 100, 23, 93, 99)

        val reduce = numbers.reduce { a: Int, b: Int -> a.coerceAtLeast(b) }
        println(reduce)

    }
}