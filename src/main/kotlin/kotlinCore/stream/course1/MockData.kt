package kotlinCore.stream.course1

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.common.collect.ImmutableList
import com.google.common.io.Resources
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import kotlinCore.stream.course1.models.Car
import kotlinCore.stream.course1.models.Person
import org.apache.commons.io.IOUtils
import java.io.FileReader
import java.io.InputStream
import java.lang.reflect.Type

fun main() {
    val pers = MockData.getPeopleGson()
    val cars = MockData.getCarGson()
    val personjack = MockData.getPeopleJackson()
    val carsjack = MockData.getCarsJackson()

}

object MockData {

    private val gson = Gson()
    private val mapper = jacksonObjectMapper()
    fun getPeopleJava(): ImmutableList<Person> {
        val inputStream: InputStream = Resources.getResource("resourcesStreamApi1/people.json").openStream()
        val json: String = IOUtils.toString(inputStream)
        val listType: Type = object : TypeToken<ArrayList<Person>>() {}.type
        val people: List<Person> = Gson().fromJson(json, listType)
        return ImmutableList.copyOf(people)
    }

    fun getCarsJava(): ImmutableList<Car> {
        val inputStream: InputStream = Resources.getResource("resourcesStreamApi1/cars.json").openStream()
        val json: String = IOUtils.toString(inputStream)
        val listType: Type = object : TypeToken<ArrayList<Car>>() {}.type
        val cars: List<Car> = Gson().fromJson(json, listType)
        return ImmutableList.copyOf(cars)
    }

    fun getPeopleJackson(): MutableList<Person> {
        return mapper.readValue(FileReader("src/main/resources/resourcesStreamApi1/people.json"))
    }

    fun getCarsJackson(): MutableList<Car> {
        return mapper.readValue(FileReader("src/main/resources/resourcesStreamApi1/cars.json"))
    }


    fun getPeopleGson(): MutableList<Person> {
        val arrayPersonType = object : TypeToken<ArrayList<Person>>() {}.type
        return gson.fromJson(FileReader("src/main/resources/resourcesStreamApi1/people.json"), arrayPersonType)
    }

    fun getCarGson(): MutableList<Car> {
        val arrayCarType = object : TypeToken<ArrayList<Car>>() {}.type
        return gson.fromJson(FileReader("src/main/resources/resourcesStreamApi1/cars.json"), arrayCarType)
    }


}

