package dsl.ex2.builder

import dsl.ex2.model.Person

class PersonBuilderDsl {
    private var person = Person()

    var name: String
        get() {
            return person.name
        }
        set(value) {
            person.name = value
        }

    var age: Int
        get() {
            return person.age
        }
        set(value) {
            person.age = value
        }

    var city: String
        get() {
            return person.city
        }
        set(value) {
            person.city = value
        }

    fun build(): Person {
        return person
    }


}