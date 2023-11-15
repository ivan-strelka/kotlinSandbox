fun main() {

}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

// Создание экземпляра класса
val isEven = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}

// Создание экземпляра, используя лямбду
val isEvenLam = IntPredicate { it % 2 == 0 }


