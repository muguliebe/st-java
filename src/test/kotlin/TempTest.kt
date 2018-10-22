fun main(args: Array<String>) {
    val input = "4 5 5 5 6 6 4 1 4 4 3 6 6 3 6 1 4 5 5 5 "
    val ar = input.trim().split(" ").map { it.trim().toInt() }.toTypedArray()
    ar.sort()
    ar.forEach { print(it.toString() + " ") }
}
