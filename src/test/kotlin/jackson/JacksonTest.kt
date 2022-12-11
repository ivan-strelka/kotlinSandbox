package jackson

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class JacksonTest {

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

        val map = mapOf("sdf" to "sdff", 1 to 123.68).toJsonString().also { println("$it это map") } // в json через
        val map2 = mapOf("sdf" to "sdff", 1 to 123.68).toJson().also { println("$it это map2") } // в json через

    }

    @Test
    fun name2() {

        val list = listOf("sdf", "sdfs", "sdfds").toJsonString().also { println(it) }
        list.get(Random().nextInt(list.length)).also { println(it) } // вернется символ тк это единый стринг

        val list2 = listOf("sdf", "sdfs", "sdfds").also { println(it) }
        list2.randomOrNull().also { println(it) } // вернется элемент тк это массиво элементов
        list2.randomOrNullJ().also { println(it) } // через функцию расширения

    }
}