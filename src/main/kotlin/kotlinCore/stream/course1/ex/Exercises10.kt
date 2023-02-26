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

    @Test
    fun name() {
        val mapIndexed = listOf(1, 2, 3, 4, 5)
            .map { n -> n * (n + 1) / 2 }
            .mapIndexed { index, n -> "Triangular number $index: $n" }

        mapIndexed.forEach { println(it) }
    }

    @Test
    fun name2() {

        val numbers = listOf(1, 2, 3)
        val words = listOf("one", "two", "three")
        val zip = numbers.zip(words)
        println(zip)

    }

    @Test
    fun name3() {

        val numbers = listOf(1, 2, 3)
        val words = listOf("one", "two", "three")
        val zip = numbers.zip(words)
        val (ints, strings) = zip.unzip()
        println(ints)
        println(strings)

        val unzip = zip.unzip()
        println(unzip)


    }

    @Test
    fun name4() {
        val squares = listOf(1, 2, 3, 4, 5)
            .associate { n -> n to n * n }

        val squares2 = listOf(1, 2, 3, 4, 5).associateWith { n -> n * n }

        println(squares)
        println(squares2)

    }
}