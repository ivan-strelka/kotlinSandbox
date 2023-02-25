package kotlinCore.stream.course1.ex

import org.junit.jupiter.api.Test


class Exercises11 {

    @Test
    fun joiningStrings() {
        val names: List<String> = mutableListOf("anna", "john", "marcos", "helena", "yasmin")

        var join = ""

        for (name in names) {
            join += "$name, "
        }

        println(join.substring(0, join.length - 2))

    }

    @Test
    fun joiningStringsWithStream() {
        val names: List<String> = mutableListOf("anna", "john", "marcos", "helena", "yasmin")

        val joinToString = names.joinToString(", ") { it.uppercase() }
        val joinToString2 = names.map { it.uppercase() }.joinToString(", ")

        println(joinToString)
        println(joinToString2)

    }

}