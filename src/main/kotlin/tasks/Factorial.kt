package tasks

fun main() {
    val factorialTwo = factorialSequence(1)
    println(factorialTwo.joinToString())


    println(factRec(6))

    println(factWhen(6))

    factLoop(6)

    whileLoop(10)

    println(factorial(7))

}

fun factorialSequence(num: Int) = sequence<Int> {
    var sum = 1
    var result = 1
    repeat(num) {
        result *= sum
        sum += 1
        yield(result)
    }

}

fun factRec(n: Int): Int {
    if (n != 1) {
        return n * factRec(n - 1).also { println(it) };
    } else return 1
}

fun factWhen(n: Int): Int {
    return when (n) {
        1 -> 1
        else -> n * factWhen(n - 1).also { println(it) }
    }
}

fun factLoop(num: Int) {

    var factorial: Long = 1
    for (i in 1..num) {
        // factorial = factorial * i;
        factorial *= i.toLong()
    }
    println("Factorial of $num = $factorial")
}

fun whileLoop(num: Int) {
    var i = 1
    var factorial: Long = 1
    while (i <= num) {
        factorial *= i.toLong()
        i++
    }
    println("Factorial of $num = $factorial")
}

fun factorial(n: Int): Double {
    // Мутирующая переменная (var)
    var result = 1.0
    for (i in 1..n) {
        result = result * i
    }
    return result
}