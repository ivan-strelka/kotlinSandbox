package dsl.ex2.dsl

import dsl.ex2.builder.PersonBuilderDsl
import dsl.ex2.model.Person

fun person(personBuilder: PersonBuilderDsl.() -> Unit): Person {
    return PersonBuilderDsl().apply(personBuilder).build()
}