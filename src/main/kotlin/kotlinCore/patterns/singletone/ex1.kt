import kotlin.concurrent.thread

fun main() {
    repeat(999) {
        thread { println(New.getInstance()) }
    }


}

class New private constructor() {
    companion object {
        @Volatile
        private var instance: New? = null

        fun getInstance(): New {
            if (instance == null) {
                synchronized(New::class.java) {
                    if (instance == null) {
                        instance = New()
                    }
                }
            }
            return requireNotNull(instance)
        }
    }
}