package kotlinCore.patterns.abstractFactory.ex1

class Game(val factory: Factory) {
    private val terrain: Terrain = factory.createTerrain()
    private val tree: Vegetation = factory.createVegetation()
}

//https://in-kotlin.com/design-patterns/abstract-factory/