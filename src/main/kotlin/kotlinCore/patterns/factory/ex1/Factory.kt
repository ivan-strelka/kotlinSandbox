package kotlinCore.patterns.factory.ex1

class Factory {
    companion object {
        fun createDevBySpec(speciality: DeveloperEnum): DeveloperFactory {
            return when (speciality) {
                DeveloperEnum.JAVA -> JavaDeveloperFactory()
                DeveloperEnum.PHP -> PhpDeveloperFactory()
                DeveloperEnum.CPP -> CppDeveloperFactory()
            }
        }
    }
}

fun main() {
    val developerFactory = Factory.createDevBySpec(DeveloperEnum.JAVA)
    val dev = developerFactory.creteDeveloper()
    dev.writeCode()

}
