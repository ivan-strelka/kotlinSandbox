package kotlinCore.patterns.builder.ex1

class Person {
    var name: String? = null
        get() = field
    var age: Int? = null
        get() = field
    var lastName: String? = null
        get() = field

    fun withName(v: String) = apply { name = v }
    fun withAge(v: Int) = apply { age = v }
    fun withLastname(v: String) = apply { lastName = v }

}

