package jackson

import com.google.gson.Gson

interface JsonConvertable {


}

//inline fun <reified T : JsonConvertable> JsonConvertable.toObject(): T = Gson().fromJson(this, T::class.java)
inline fun <reified T : JsonConvertable> String.toObject(): T = JacksonJsonUtils.fromJson(this, T::class.java)
fun Any.toJson(): String = JacksonJsonUtils.toJson(this)