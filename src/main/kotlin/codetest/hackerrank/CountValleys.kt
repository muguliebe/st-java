package codetest.hackerrank

import java.util.*

fun countingValleys(n: Int, s: String): Int {
    var level = 0
    var point = 0

    s.toCharArray().forEachIndexed { index, c ->
        when (c) {
            'U' -> level++
            'D' -> level--
        }
        if (level == 0 && s[index] == 'U') {
            point++
        }
    }
    return point
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

//    val n = scan.nextLine().trim().toInt()
//    val ar = scan.nextLine().trim().split(" ").map { it.trim().toInt() }.toTypedArray()

    val input = "DDUUDDUDUUUD"

    val n = input.length
    val s = input
    val result = countingValleys(n, s)

    println(result)
}
