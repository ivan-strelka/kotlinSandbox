package kotlinCore.stream.course1.ex

import com.google.common.collect.Lists
import org.junit.jupiter.api.Test


class Exercises10 {
    private val arrayListOfNames: List<ArrayList<String>> = Lists.newArrayList(
        Lists.newArrayList("Mariam", "Alex", "Ismail"),
        Lists.newArrayList("John", "Alesha", "Andre"),
        Lists.newArrayList("Susy", "Ali")
    )


    @Test
    fun withoutFlatMap() {
//    [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

        println("arrayListOfNames -> $arrayListOfNames")

        val names: MutableList<String> = Lists.newArrayList()

        for (listOfNames in arrayListOfNames) {
            for (name in listOfNames) {
                names.add(name)
            }
        }

        println(names)

    }

    @Test
    fun withFlatMap() {
//   [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        val flatMap = arrayListOfNames.flatten()
        val flatMap2 = arrayListOfNames.flatMap { it }

        println(flatMap)
        println(flatMap2)
    }


}