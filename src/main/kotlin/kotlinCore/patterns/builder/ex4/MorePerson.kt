package kotlinCore.patterns.builder.ex4

class Person() {
    var name = ""
    var address = ""
    var age = 0
}

class PersonBuilder() {

    private var name = ""
    private var address = ""
    private var age = 0

    fun setName(name: String) = apply {
        this.name = name
    }

    fun setAddress(address: String) = apply {
        this.address = address
    }

    fun setAge(age: Int) = apply {
        this.age = age
    }

    fun canBuild(): Boolean {
        // do business rules, checks
        return true
    }

    fun build(): Person {
        val person = Person()
        if (canBuild()) {
            person.address = address
            person.name = name
            person.age = age
        }
        return person
    }
}