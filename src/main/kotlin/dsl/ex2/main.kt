package dsl.ex2

import dsl.ex2.builder.PersonBuilderDsl
import dsl.ex2.dsl.person

fun main() {

    var person1 = PersonBuilderDsl().apply {
        age = 12
        name = "john"
        city = "NY"
    }.build()

    var person2 = person {
        age = 334
        name = "Alex"
        city = "Paris"
    }
}