package kotlinCore.patterns.factory.ex1

class PhpDeveloperFactory : DeveloperFactory {
    override fun creteDeveloper(): Developer {
        return PhpDeveloper()
    }
}