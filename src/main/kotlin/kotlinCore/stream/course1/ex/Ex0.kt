package kotlinCore.stream.course1.ex

import org.junit.jupiter.api.Test

class Ex0 {


    data class A(
        val testName: String,
        val testList: List<B>
    ) {
        data class B(
            val testString: String,
            val testB: String
        )
    }

    val a = listOf(
        A("asd", listOf(A.B("dghfjsg", "ahdgj"))),
        A("asdgh", listOf(A.B("yuewydgh", "djkhfj"))),
        A("sgf", listOf(A.B("opuiu", "sajhja")))
    )

    @Test
    fun testName() {
        val map = a.filter { it.testName == "asd" }.flatMap { it.testList.filter { it.testString == "dghfjsg" } }
    }


    @Test
    fun target() {

        val target = mutableListOf<Int>()
        listOf(1, 2, 3, 4, 5, 6, 10, 11).filterTo(target) { n -> n % 2 == 0 }

        println(target)
    }
}