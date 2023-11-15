package `functionalInterface `

import java.util.function.Consumer
import java.util.function.Function
import java.util.function.Predicate

// Функциональный интерфейс с одним абстрактным методом
fun interface MyFunctionalInterface {
    fun execute()
}

// Использование функционального интерфейса
val myFunction: MyFunctionalInterface = object : MyFunctionalInterface {
    override fun execute() {
        println("Выполнение функции")
    }
}

val myFunction2 = MyFunctionalInterface { println("Привет") }

// Лямбда-выражение
val myLambda: () -> Unit = {
    println("Выполнение функции (через лямбда)")
}


interface MyFunctionalInterface2 {
    fun myMethod(x: Int): Boolean
}

val myFun: MyFunctionalInterface2 = object : MyFunctionalInterface2 {
    override fun myMethod(x: Int): Boolean {
        return x > 0
    }
}


fun interface Converter2<T, N> {
    fun convert(t: T): N
}

val lam: (Int) -> Boolean = { x -> x > 0 }


val intPredicate = Predicate { x: Int -> x % 2 == 0 }
val consumerLym = Consumer { x: String -> println(x) }
val function = Function { x: String -> x.length }
val convert = Converter2 { x: String -> x.toIntOrNull() ?: 0 }

fun main() {
    myFunction.execute()
    myLambda()
    myFun.myMethod(5)
    lam(5)
    consumerLym.accept("Привет Consumer")
    println(intPredicate.test(9))
    println(intPredicate.test(10))
    println(function.apply("Function"))
    println(convert.convert("123"))

}

