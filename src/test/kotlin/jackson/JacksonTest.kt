package jackson

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

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
}