package demo

fun main(args: Array<String>) {
    println("hello kotlin")

    val sum = sum(1, 3)
    println("sum = ${sum}")

    println("maxOf(1,3) = ${maxOf(1, 3)}")

    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.forEach { i -> println(i) }

    val customer = Customer("what")
    println("customer.id = ${customer.id}")
}

fun sum(a: Int, b: Int) = a + b
fun maxOf(a: Int, b: Int) = if (a > b) a else b
