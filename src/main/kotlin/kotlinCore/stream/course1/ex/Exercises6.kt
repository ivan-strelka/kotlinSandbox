package kotlinCore.stream.course1.ex


import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.`is`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Exercises6 {

    @Test
    fun findAny() {
        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val any: Int = numbers
            .filter { it < 5 }
            .random()

        println(any)
        assertThat(any, anyOf(`is`(1), `is`(2), `is`(3), `is`(4)))

    }

    @Test
    fun findFirst() {
        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val any: Int = numbers.first { it < 5 }

        println(any)
        Assertions.assertEquals(any, 1)
    }

}