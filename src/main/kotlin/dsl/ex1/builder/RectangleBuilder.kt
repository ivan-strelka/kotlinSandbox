package builder

import dsl.ex1.builder.ItemBuilder
import dsl.ex1.domain.Rectangle

class RectangleBuilder : ItemBuilder() {

    private var rectangle: Rectangle
        get() {
            return item as Rectangle
        }
        set(value) {
            item = value
        }

    var color: String
        get() {
            return rectangle.color
        }
        set(value) {
            rectangle.color = value
        }

    init {
        item = Rectangle()
    }
}