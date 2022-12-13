package jackson

import dsl.ex2.builder.PersonBuilderDsl
import dsl.ex2.dsl.person
import jackson.model.MainBooker
import org.amshove.kluent.`should contain`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import pattern.builder.ex1.Person
import java.util.*

class AnyTests {

    @Test
    fun name() {
        val obj = MainBooker("ASU", "dylan", "12", "2233-44", "NY", "342-234-44", "df@dfs.com")
        val toJson = obj.toJson().also { println(it) } // обратно в json
        val json = JacksonJsonUtils.toJson(obj).also { println(it) } // в json через вызов метода
        val toObject = json.toObject<MainBooker>().also { println(it) } // в объект
        val toObject2 = toJson.toObject<MainBooker>().also { println(it) } // // в объект
        val (country, street, streetNumber, postal_code, city, phone, email) = json.toObject<MainBooker>()
            .also { println(it) } // в разные переменные

        assertEquals(country, obj.country, "чот не то")
        assertEquals(toObject2.country, obj.country, "чот не то")
        assertEquals(toObject.country, obj.country, "чот не то")
    }

    @Test
    fun name1() {

        val map = mapOf("sdf" to "sdff", 1 to 123.68).toJsonString().also { println("$it это map") } // в json через Map
        val map2 = mapOf("sdf" to "sdff", 1 to 123.68).toJson().also { println("$it это map2") } // в json через Any

    }

    @Test
    fun name2() {

        val list = listOf("sdf", "sdfs", "sdfds").toJsonString().also { println(it) }
        list.get(Random().nextInt(list.length)).also { println(it) } // вернется символ тк это единый стринг

        val list2 = listOf("sdf", "sdfs", "sdfds").also { println(it) }
        list2.randomOrNull().also { println(it) } // вернется элемент тк это массиво элементов
        list2.randomOrNullJ().also { println(it) } // через функцию расширения

    }

    @Test
    fun builderTest() {
        val obj =
            Person()
                .withAge(123)
                .withName("John")
                .withLastname("Doe")


        val json = obj.toJson().also { println(it) } // преобразуем в json

        // тестим что в json тоже самое что и в объекте
        json `should contain` obj.age.toString()
        json `should contain` obj.name.toString()
        json `should contain` obj.lastName.toString()

    }

    @Test
    fun nameDsl() {
        val person = PersonBuilderDsl().apply {
            age = 12
            name = "john"
            city = "NY"
        }.build()

        person.printSelf()

        val toJson = person.toJson()

        toJson.printSelf()

        toJson `should contain` person.name
        toJson `should contain` person.age.toString()
        toJson `should contain` person.city

    }

    @Test
    fun nameDsl2() {
        val person2 = person {
            age = 334
            name = "Alex"
            city = "Paris"
        }
        person2.printSelf()

        val toJson = person2.toJson()

        toJson.printSelf()

        toJson `should contain` person2.name
        toJson `should contain` person2.age.toString()
        toJson `should contain` person2.city

    }
}