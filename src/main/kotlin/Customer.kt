package demo

data class Customer(val id: String="") {
    init {
        println("init called:" + id)

    }
}
