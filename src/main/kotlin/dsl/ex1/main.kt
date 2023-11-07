import builder.RectangleBuilder
import dsl.ex1.builder.ImageBuilder
import dsl.ex1.builder.ItemBuilder
import dsl.image
import dsl.rectangle
import dsl.window

fun main() {

    var item2 = ItemBuilder()
        .apply {
            x = 0
            y = 10
            width = 20
            height = 30

            addChild(
                ImageBuilder()
                    .apply {
                        x = 40
                        y = 50
                        width = 60
                        height = 70
                        source = "url"
                    }
                    .addChild(
                        RectangleBuilder()
                            .apply {
                                x = 80
                                y = 90
                                width = 100
                                height = 100
                                color = "red"
                            }
                    )
            )
        }.build()


    var item = window {
        x = 0
        y = 10
        width = 20
        height = 30

        image {
            x = 40
            y = 50
            width = 60
            height = 70
            source = "url"

            rectangle {
                x = 80
                y = 90
                width = 100
                height = 100
                color = "red"
            }
        }
    }

    var i = 0

}