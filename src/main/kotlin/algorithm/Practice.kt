package demo.algorithm

class Practice {
    enum class Color {
        BLACK, WHITE
    }
}

fun main(args: Array<String>) {
    var vert: MutableList<Practice.Color> = mutableListOf()
    vert.add(Practice.Color.WHITE)
    println("vert = ${vert}")
}


fun countOccurences(s: String, sub: String): Int = s.split(sub).size - 1
