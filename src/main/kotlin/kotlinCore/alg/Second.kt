package kotlinCore.alg

import org.junit.Assert.assertArrayEquals


fun main() {
    assertArrayEquals(intArrayOf(2, 4, 6), maps(intArrayOf(1, 2, 3)))
    assertArrayEquals(intArrayOf(8, 2, 2, 2, 8), maps(intArrayOf(4, 1, 1, 1, 4)))
    assertArrayEquals(intArrayOf(4, 4, 4, 4, 4, 4), maps(intArrayOf(2, 2, 2, 2, 2, 2)))
}

fun evenOrOdd(number: Int): String {
    return if (number % 2 == 0) {
        "Even"
    } else {
        "Odd"
    }
}

fun evenOrOddWhen(number: Int?): String {
    return when {
        number == null -> "null"
        number % 2 == 0 -> "Even"
        else -> "Odd"
    }
}

fun countPositivesSumNegatives(input: Array<Int>?): Array<Int> {
    if (input.isNullOrEmpty()) return emptyArray()

    val positiveCount = input.count { it > 0 }
    val negativeSum = input.filter { it < 0 }.sum()

    return arrayOf(positiveCount, negativeSum)
}

fun countPositivesSumNegatives2(input: Array<Int>?): Array<Int> {
    if (input.isNullOrEmpty()) return emptyArray()
    val (positive, negative) = input.partition { it > 0 }
    return arrayOf(positive.count(), negative.sum())
}

fun countPositivesSumNegatives3(input: Array<Int>?) = input?.takeIf { it.isNotEmpty() }
    ?.let { listOf(it.filter { it > 0 }.count(), it.filter { it < 0 }.sum()) }?.toTypedArray() ?: arrayOf()

fun countPositivesSumNegatives4(input: Array<Int>?): Array<Int> {
    if (input.isNullOrEmpty()) return emptyArray()
    return input.partition { it > 0 }.let { arrayOf(it.first.count(), it.second.sum()) }
}

fun dutyFree(normPrice: Int, discount: Int, hol: Int): Int {
    return hol * 100 / normPrice / discount
}

fun maps(x: IntArray): IntArray {
    return x.map { it * 2 }.toIntArray()
}

fun maps2(x: IntArray): IntArray = IntArray(x.size, { x[it] * 2 })