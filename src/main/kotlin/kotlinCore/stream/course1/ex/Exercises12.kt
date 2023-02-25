package kotlinCore.stream.course1.ex

import kotlinCore.stream.course1.MockData
import org.junit.jupiter.api.Test

class Exercises12 {

    @Test
    fun test() {
        val cars = MockData.getCarsJackson()

        val message = cars
            .filter { car ->
                println("filter car -> $car")
                car.price < 10000
            }
            .map { car ->
                println("map car -> $car")
                car.price
            }
            .map { price ->
                println("mapping price -> $price")
                println("old price -> $price")
                val d = price + (price * 0.14)
                println("new price -> $d")
                d
            }


        println(
            message
        )

    }

}