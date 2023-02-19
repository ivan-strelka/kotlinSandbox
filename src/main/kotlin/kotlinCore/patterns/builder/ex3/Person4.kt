package kotlinCore.patterns.builder.ex3


class Person4 {
    var name = ""
    var address = ""
    var age = 0

    fun setName(name: String): Person4 {
        this.name = name
        return this
    }

    fun setAddress(address: String): Person4 {
        this.address = address
        return this
    }

    fun setAge(age: Int): Person4 {
        this.age = age
        return this
    }

    override fun toString(): String {
        return "Person4(name='$name', address='$address', age=$age)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person4

        if (name != other.name) return false
        if (address != other.address) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + age
        return result
    }


}