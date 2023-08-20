package kotlinCore.patterns.observer

fun main() {
    println(getRandomMeetingInfo())
    println(getRandomMeetingInfo())
    println(getRandomMeetingInfo())
    println(getRandomMeetingInfo())
    println(getRandomMeetingInfo())
    println(getRandomMeetingInfo())
    println(getRandomMeetingInfo())
    println(getRandomMeetingInfo())
    println(getRandomMeetingInfo())
}

fun getRandomMeetingInfo(): String {
    return when (listOf("UFA", "MOSCOW", "NOVOSIBIRSK").random()) {
        "UFA" -> "1"
        "MOSCOW" -> "2"
        else -> "3"
    }
}