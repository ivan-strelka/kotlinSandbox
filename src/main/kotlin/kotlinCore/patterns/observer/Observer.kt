package kotlinCore.patterns.observer

fun main() {

    val cardObservable = CardObservable()
    val bottomBar = BottomBar()
    val profile = Profile()
    val pdp = Pdp()

    println("----------------1----------------")
    cardObservable.registerObserver(bottomBar)
    cardObservable.notifyObservers(CartState(3))

    println("----------------2----------------")
    cardObservable.registerObserver(profile)
    cardObservable.registerObserver(pdp)
    cardObservable.notifyObservers(CartState(1))

    println("----------------3----------------")
    cardObservable.removeObserver(profile)
    cardObservable.notifyObservers(CartState(0))


}

interface Observer<T> {
    fun update(data: T)
}

interface Observable<T> {
    val observers: ArrayList<Observer<T>>
    fun registerObserver(observer: Observer<T>) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer<T>) {
        observers.remove(observer)
    }

    fun notifyObservers(data: T) {
        observers.forEach { it.update(data) }
    }
}

data class CartState(val productCount: Int)

class CardObservable : Observable<CartState> {
    override val observers: ArrayList<Observer<CartState>> = ArrayList()
}

class BottomBar() : Observer<CartState> {
    override fun update(data: CartState) {
        println("BottomBar has received ${data.productCount} products")
    }
}

class Profile() : Observer<CartState> {
    override fun update(data: CartState) {
        println("Profile has received ${data.productCount} products")
    }
}

class Pdp() : Observer<CartState> {
    override fun update(data: CartState) {
        println("Pdp has received ${data.productCount} products")
    }
}