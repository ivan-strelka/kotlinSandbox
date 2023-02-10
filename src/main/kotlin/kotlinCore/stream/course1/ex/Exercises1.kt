package kotlinCore.stream.course1.ex

import kotlinCore.stream.course1.MockData.getPeopleGson
import kotlinCore.stream.course1.MockData.getPeopleJackson
import kotlinCore.stream.course1.MockData.getPeopleJava
import kotlinCore.stream.course1.models.Person
import org.junit.jupiter.api.Test


class Exercises1 {

    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people

    @Test
    fun imperativeApproach() {
        val people = getPeopleJava()

        val youngPeople: MutableList<Person> = mutableListOf()
        val limit = 10
        var counter = 0
        for (person in people) {
            if (person.age <= 18) {
                youngPeople.add(person)
                counter++
                if (counter == limit) {
                    break
                }
            }
        }
        for (young in youngPeople) {
            println(young)
        }
    }

    @Test
    fun declarativeApproachUsingStreams() {
        val people = getPeopleJava()

        val youngPeople = people.filter { person -> person.age <= 18 }.take(10)

        youngPeople.forEach { println(it) }

    }

    @Test
    fun name() {
        val people = getPeopleJackson()

        val youngPeople = people.filter { person -> person.age <= 18 }.take(10)

        youngPeople.forEach { println(it) }
    }

    @Test
    fun name2() {
        val people = getPeopleGson()

        val youngPeople = people.filter { person -> person.age <= 18 }.take(10)

        youngPeople.forEach { println(it) }
    }
}