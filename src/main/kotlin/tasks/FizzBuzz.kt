package tasks

import java.io.Serializable
import java.util.stream.IntStream

fun main() {

    // решение через цикл
    fizzBuzz()

    // решение через when
    (1..100).map {
        println(fizzBuzzWhen(it))
    }

    // решение через потоки - Java IntStream
    fizzBuzzJava()

    fizzBuzzWhen(200)

    println("fizzBuzz3")
    println(fizzBuzz3(15))

}

fun fizzBuzz() {
    for (n in 1..100) {
        if (n % 15 == 0) {
            println("Fizz Buzz = $n")
            continue
        } else if (n % 5 == 0) {
            println("Buzz = $n")
            continue
        } else if (n % 3 == 0) {
            println("Fizz = $n")
            continue
        }
        println("$n")
    }
}

fun fizzBuzzWhen(n: Int) = when {
    n % 15 == 0 -> "FizzBuzz"
    n % 5 == 0 -> "Buzz"
    n % 3 == 0 -> "Fizz"
    else -> n
}

fun fizzBuzzJava() = IntStream.rangeClosed(1, 100)
    .mapToObj { n: Int ->
        if (n % 3 == 0)
            if (n % 15 == 0) "Fizz Buzz = $n"
            else "Fizz = $n"
        else if (n % 5 == 0) "Buzz = $n"
        else n
    }
    .forEach { x: Serializable? -> println(x) }

fun fizzBuzz(num: Int): String {
    var result = ""

    if (num % 3 == 0) {
        result = "Fizz"
    }

    if (num % 5 == 0) {
        result += "Buzz"
    }

    if (result == "") {
        result = num.toString()
    }

    return result;
}

fun fizzBuzz2(num: Int): String {
    return if (num % 3 == 0) "Fizz"
    else if (num % 5 == 0) "Buzz"
    else if (num % 3 == 0 && num % 5 == 0) "FizzBuzz"
    else "$num"
}

fun fizzBuzz3(num: Int): String {
    return when {
        num % 3 == 0 && num % 5 == 0 -> "FizzBuzz"
        num % 3 == 0 -> "Fizz"
        num % 5 == 0 -> "Buzz"
        else -> "$num is not FizzBuzz"
    }
}


