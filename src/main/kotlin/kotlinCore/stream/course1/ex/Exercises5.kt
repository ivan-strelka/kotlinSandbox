package kotlinCore.stream.course1.ex

import kotlinCore.stream.course1.MockData
import kotlinCore.stream.course1.models.Car
import kotlinCore.stream.course1.models.PersonDTO
import kotlinCore.stream.course1.models.toPersonDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class Exercises5 {

    @Test
    fun filtering() {
        val cars = MockData.getCarsGson()
        val filter = cars.filter { car -> car.price < 20000 }
        println(filter)
    }


    @Test
    fun ourFirstMapping() {
        // transform from one data type to another
        val people = MockData.getPeopleGson()
        val map = people.map { it.toPersonDTO() }
        val map2 = people.map { p -> PersonDTO(p.firstName, p.id, p.age) }
        val map3 = people.map(PersonDTO::map)
        Assertions.assertEquals(map.size, 1000)
        Assertions.assertEquals(map2.size, 1000)
        Assertions.assertEquals(map3.size, 1000)

    }

    @Test
    fun averageCarPrice() {
        // calculate average of car prices
        val cars = MockData.getCarsGson()
        val map = cars.map { it.price }.average()
        val map2 = cars.map(Car::price).average()
        println(map)
        println(map2)
        Assertions.assertEquals(map, 52693.19979000003)
        Assertions.assertEquals(map2, 52693.19979000003)


    }

    @Test
    fun test() {


    }

}