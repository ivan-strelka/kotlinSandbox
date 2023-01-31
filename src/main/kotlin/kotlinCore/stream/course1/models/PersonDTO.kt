package kotlinCore.stream.course1.models

data class PersonDTO(
    val name: String,
    val id: Int,
    val age: Int
) {
    fun map(person: Person): PersonDTO {
        return PersonDTO(id = person.id, name = person.firstName, age = person.age)
    }

}



