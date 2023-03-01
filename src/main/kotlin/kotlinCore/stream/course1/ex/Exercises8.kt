package kotlinCore.stream.course1.ex

import kotlinCore.stream.course1.MockData
import org.junit.jupiter.api.Test


class Exercises8 {

    @Test
    fun simpleGrouping() {
        val cars = MockData.getCarsJackson()

//        val groupBy = cars.groupBy { it.price }.flatMap { it.value }.map { it.price }
//        val groupBy1 = cars.groupBy { it.price }
//        val groupB2y = cars.groupingBy { it.price }.eachCount()
//        val groupB3y = cars.groupingBy { it.price }

        val groupBy11 = cars.groupBy { it.make }

        groupBy11.forEach { (make, car) ->
            println(make)
            car.forEach { println(it) }
        }

    }

    @Test

    fun groupingAndCounting() {
        val names = listOf(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        )
        val counting = names.groupingBy { it }.eachCount()

        counting.forEach { (name, count) ->
            println("$name > $count")
        }
    }
}