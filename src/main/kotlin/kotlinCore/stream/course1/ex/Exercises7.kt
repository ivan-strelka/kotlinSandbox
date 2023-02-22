package kotlinCore.stream.course1.ex


import kotlinCore.stream.course1.MockData
import kotlinCore.stream.course1.models.Car
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class Exercises7 {

    @Test
    fun count() {
        val count = MockData.getPeopleGson()
            .filter { person -> person.gender.equals("female", true) }
            .count()

        val count2 = MockData.getPeopleGson()
            .count { person -> person.gender.equals("female", true) }

        println(count)
        println(count2)

        Assertions.assertEquals(count, 467)
        Assertions.assertEquals(count2, 467)

    }

    @Test
    fun min() {
        val cars = MockData.getCarsJackson()
            .filter { car -> car.color.equals("yellow", true) }
            .map { it.price }
            .min()

        val cars2 = MockData.getCarsJackson()
            .filter { car -> car.color.equals("yellow", true) }.minOfOrNull { it.price }

        println(cars)
        Assertions.assertEquals(cars, 6600.59)


    }

    @Test

    fun max() {
        val cars = MockData.getCarsJackson()
            .filter { car -> car.color.equals("yellow", true) }
            .map { it.price }
            .max()

        val cars2 = MockData.getCarsJackson()
            .filter { car -> car.color.equals("yellow", true) }.maxOfOrNull { it.price }

        println(cars)
        Assertions.assertEquals(cars, 99677.14)

    }


    @Test
    fun average() {
        val cars = MockData.getCarsJackson()
            .map { it.price }
            .average()

        println(cars)

        Assertions.assertEquals(cars, 52693.19979000003)

    }

    @Test
    fun sum() {
        val cars = MockData.getCarsJackson()
            .map { it.price }
            .sum()
            .toBigDecimal()

        val cars2 = MockData.getCarsJackson()
            .sumOf { it.price }
            .toBigDecimal()

    }

    @Test
    fun statistics() {
        val cars = MockData.getCarsJackson()

        val statistics = cars.stream()
            .mapToDouble(Car::price)
            .summaryStatistics()

        println(statistics)
        println(statistics.max)
        println(statistics.count)
        println(statistics.sum)
        println(statistics.min)
        println(statistics.average)

    }
}