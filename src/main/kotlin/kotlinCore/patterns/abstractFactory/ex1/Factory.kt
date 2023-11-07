package kotlinCore.patterns.abstractFactory.ex1

interface Factory {
    fun createTerrain(): Terrain
    fun createVegetation(): Vegetation
}

