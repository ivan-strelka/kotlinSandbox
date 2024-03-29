package tasks

fun String.reverse(): String {
    return this.mapIndexed { index, _ ->
        this[(this.length - 1) - index]
    }.joinToString("")
}

fun strReverse(text: String): String {
    val size = text.length - 1

    return text.mapIndexed { index, _ ->
        text[size - index]
    }.joinToString("")
}