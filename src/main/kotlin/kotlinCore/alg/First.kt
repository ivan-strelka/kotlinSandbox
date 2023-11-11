package kotlinCore.alg

fun main() {
    val numbers = arrayOf(5, 2, 9, 1, 7)
    val maxNumber = findMax(numbers)
    println("Максимальный элемент: $maxNumber")

    val maxNumber3 = findMax3(numbers)
    println("Максимальный элемент: $maxNumber3")
}

fun findMax(arr: Array<Int>): Int? {
    if (arr.isEmpty()) return null
    var max = arr[0]
    for (j in arr) {
        if (j > max) {
            max = j
        }
    }
    return max
}

fun findMax3(arr: Array<Int>): Int? {
    return if (arr.isEmpty()) {
        null
    } else {
        findMaxRecursive(arr, 0, arr.size - 1)
    }
}

fun findMaxRecursive(arr: Array<Int>, start: Int, end: Int): Int {
    return if (start == end) {
        arr[start]
    } else {
        val middle = (start + end) / 2
        val maxLeft = findMaxRecursive(arr, start, middle)
        val maxRight = findMaxRecursive(arr, middle + 1, end)
        if (maxLeft > maxRight) maxLeft else maxRight
    }
}

