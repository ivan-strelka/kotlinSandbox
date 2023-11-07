package kotlinCore.patterns.abstractFactory.ex1

class DesertFactory : Factory {

    override fun createTerrain(): Terrain {
        return Sand()
    }

    override fun createVegetation(): Vegetation {
        return Cactus()
    }
}