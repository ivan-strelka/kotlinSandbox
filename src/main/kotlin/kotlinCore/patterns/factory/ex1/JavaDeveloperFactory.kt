package kotlinCore.patterns.factory.ex1

class JavaDeveloperFactory : DeveloperFactory {
    override fun creteDeveloper(): Developer {
        return JavaDeveloper()
    }
}