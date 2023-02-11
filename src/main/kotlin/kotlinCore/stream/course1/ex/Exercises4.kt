package kotlinCore.stream.course1.ex

import org.junit.jupiter.api.Test


class Exercises4 {
//  Removing duplicates in a List

    @Test
    fun distinct() {
        val numbers: List<Int> = mutableListOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9)
        val distinct = numbers.distinct()
        println(distinct)
    }

    @Test
    fun toSet() {
        val numbers: List<Int> = mutableListOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9)
        val toSet = numbers.toSet()
        println(toSet)

    }

    @Test
    fun toHashSet() {
        val numbers: List<Int> = mutableListOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9)
        val toHashSet = numbers.toHashSet()
        println(toHashSet)
    }

    @Test
    fun toMutableSet() {
        val numbers: List<Int> = mutableListOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9)
        val toMutableSet = numbers.toMutableSet()
        println(toMutableSet)
    }

    @Test
    fun toSetToList() {
        val numbers: List<Int> = mutableListOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9)
        val toList = numbers.toSet().toList()
        println(toList)
    }
}