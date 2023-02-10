package kotlinCore.stream.course1.ex

import kotlinCore.stream.course1.MockData.getPeopleJava
import kotlinCore.stream.course1.models.Person
import org.junit.jupiter.api.Test
import java.util.stream.IntStream


class Exercises2 {

    @Test
    fun range() {
        println("for i")
        for (i in 0..10) {
            println(i)
        }
        println("exclusive")
        IntStream.range(0, 10).forEach { x: Int -> println(x) }
        println("inclusive")
        IntStream.rangeClosed(0, 10).forEach { x: Int -> println(x) }
    }

    @Test
    fun rangeIteratingLists() {
        val people = getPeopleJava()

        IntStream.range(0, people.take(10).size)
            .forEach { index: Int ->
                val person: Person = people[index]
                println(person)
            }
    }

    @Test
    fun rangeIteratingList2s() {
        val people = getPeopleJava()

        for (i in 0 until people.size) {
            println("${people[i]} ")
        }
    }

    @Test
    fun rangeIteratingList2s2() {
        val people = getPeopleJava()

        for (i in 0 until people.take(10).size) {
            println("${people[i]} ")
        }
    }

    @Test
    fun rangeIteratingLi3st2s() {
        val people = getPeopleJava()

        people.take(10).forEachIndexed { i, e -> println("people[$i] = $e") }
    }

    @Test
    fun rangeIteratingLists2() {
        val people = getPeopleJava()

        for (element in people) {
            println(element)
        }

    }


}