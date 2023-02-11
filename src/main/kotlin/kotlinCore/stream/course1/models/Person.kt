package kotlinCore.stream.course1.models

data class Person(
    val firstName: String,
    val lastName: String,
    val gender: String,
    val id: Int,
    val email: String,
    val age: Int,
)

fun Person.toPersonDTO() = PersonDTO(firstName, id, age)


//    @JvmStatic
//    @JvmName("get")
//    fun Person.toPersonDTO(): PersonDTO {
//        return PersonDTO(firstName, id, age)
//    }