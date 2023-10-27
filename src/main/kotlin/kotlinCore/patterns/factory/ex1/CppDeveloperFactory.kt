package kotlinCore.patterns.factory.ex1

class CppDeveloperFactory : DeveloperFactory {
    override fun creteDeveloper(): Developer {
        return CppDeveloper()
    }
}