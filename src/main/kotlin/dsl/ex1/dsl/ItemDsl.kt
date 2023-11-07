package dsl

import builder.RectangleBuilder
import dsl.ex1.builder.ImageBuilder
import dsl.ex1.builder.ItemBuilder
import dsl.ex1.domain.Item

fun window(itemBuilder: ItemBuilder.() -> Unit): Item {
    return ItemBuilder().apply(itemBuilder).build()
}

fun ItemBuilder.item(itemBuilder: ItemBuilder.() -> Unit) {
    val builder = ItemBuilder().apply(itemBuilder)
    addChild(builder)
}

fun ItemBuilder.rectangle(rectangleBuilder: RectangleBuilder.() -> Unit) {
    val builder = RectangleBuilder().apply(rectangleBuilder)
    addChild(builder)
}

fun ItemBuilder.image(imageBuilder: ImageBuilder.() -> Unit) {
    val builder = ImageBuilder().apply(imageBuilder)
    addChild(builder)
}