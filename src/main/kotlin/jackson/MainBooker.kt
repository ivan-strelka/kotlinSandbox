package jackson


data class MainBooker(
    val country: String,
    val street: String,
    val streetNumber: String,
    val postal_code: String,
    val city: String,
    val phone: String,
    val email: String
) : JsonConvertible
