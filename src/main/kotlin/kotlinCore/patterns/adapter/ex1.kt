package kotlinCore.patterns.adapter

fun main() {
    val card: Card = Card()
    val resource: Usb
    resource = CardAdapter(card)
    println(resource.getUsbData())
}

interface Usb {
    fun getUsbData(): String
}

class CardAdapter(
    private val card: Card
) : Usb {
    override fun getUsbData(): String {
        return "Adapted ${card.getCardData()}"
    }
}

class Card {
    fun getCardData(): String = "Card Data"
}