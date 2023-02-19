package dsl.ex3.dsl

import dsl.ex3.model.person


fun main() {

    val person = person {
        name = "John"
        age = 18

        address {
            city = "New York"
            street = "Main Street"
        }
    }
}

