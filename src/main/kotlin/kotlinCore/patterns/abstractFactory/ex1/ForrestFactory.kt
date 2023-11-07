package kotlinCore.patterns.abstractFactory.ex1

class ForrestFactory : Factory {

    override fun createTerrain(): Terrain {
        return Grass()
    }

    override fun createVegetation(): Vegetation {
        return Tree()
    }
}