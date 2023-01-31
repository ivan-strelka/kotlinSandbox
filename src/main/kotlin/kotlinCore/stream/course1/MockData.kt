package kotlinCore.stream.course1

import com.google.common.collect.ImmutableList
import com.google.common.io.Resources
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import kotlinCore.stream.course1.models.Car
import kotlinCore.stream.course1.models.Person
import org.apache.commons.io.IOUtils
import java.io.InputStream
import java.lang.reflect.Type

object MockData {
    fun getPeople(): ImmutableList<Person> {
        val inputStream: InputStream = Resources.getResource("resourcesStreamApi1/people.json").openStream()
        val json: String = IOUtils.toString(inputStream)
        val listType: Type = object : TypeToken<ArrayList<Person>>() {}.type
        val people: List<Person> = Gson().fromJson(json, listType)
        return ImmutableList.copyOf(people)
    }

    fun getCars(): ImmutableList<Car> {
        val inputStream: InputStream = Resources.getResource("resourcesStreamApi1/cars.json").openStream()
        val json: String = IOUtils.toString(inputStream)
        val listType: Type = object : TypeToken<ArrayList<Car>>() {}.type
        val cars: List<Car> = Gson().fromJson(json, listType)
        return ImmutableList.copyOf(cars)
    }
}

