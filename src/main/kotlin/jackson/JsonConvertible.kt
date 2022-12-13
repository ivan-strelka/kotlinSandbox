package jackson

import java.util.*


interface JsonConvertible

inline fun <reified T : JsonConvertible> String.toObject(): T = JacksonJsonUtils.fromJson(this, T::class.java)
fun Any.toJson(): String = JacksonJsonUtils.toJson(this)
inline fun <reified K, V> Map<K, V>.toJsonString(): String = JacksonJsonUtils.toJson(this)
inline fun <reified T> List<T>.toJsonString(): String = JacksonJsonUtils.toJson(this)
inline fun <reified T> T.printSelf() {
    println("This is printSelf fun -> $this")
}

/**
 * Returns a random element.
 */
inline fun <reified T> List<T>.randomOrNullJ(): T? = if (this.isNotEmpty()) get(Random().nextInt(size)) else null