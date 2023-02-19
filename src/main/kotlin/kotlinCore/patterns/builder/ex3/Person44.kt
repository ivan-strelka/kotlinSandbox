package kotlinCore.patterns.builder.ex3

class Person44() {
    var name = ""
    var address = ""
    var age = 0

    fun setName(name: String) = apply {
        this.name = name
    }

    fun setAddress(address: String) = apply {
        this.address = address
    }

    fun setAge(age: Int) = apply {
        this.age = age
    }

    override fun toString(): String {
        return "Person44(name='$name', address='$address', age=$age)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person44

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