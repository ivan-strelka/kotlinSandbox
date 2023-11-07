package dsl.ex1.builder

import dsl.ex1.domain.Image

class ImageBuilder : ItemBuilder() {

    init {
        item = Image()
    }

    private var image: Image
        get() {
            return item as Image
        }
        set(value) {
            item = value
        }

    var source: String
        get() {
            return image.source
        }
        set(value) {
            image.source = value
        }
}