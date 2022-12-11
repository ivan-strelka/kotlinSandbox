package ui

import org.apache.commons.lang3.RandomUtils

class Test {

    /**
     * Random item from collection
     *
     * @param collection Collection
     * @param <T>        Item type
     * @return Random item or `null` if collection is empty or is `null`
    </T> */
    fun <T> randomFromCollection(collection: Collection<T>?): T? {
        if (collection.isNullOrEmpty()) return null
        if (collection.size == 1) return collection.first()
        val byIndex = RandomUtils.nextInt(0, collection.size)
        val iterator = collection.iterator()
        for (i in 0 until byIndex) {
            iterator.next()
        }
        return iterator.next()
    }
}