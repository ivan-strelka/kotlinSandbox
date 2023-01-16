package kotlinCore.lambda

fun main() {

}

fun buildString(name: String = "name", block: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    block(sb)
    return sb.toString()
}

inline fun buildString2(block: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.block()
    return sb.toString()
}
