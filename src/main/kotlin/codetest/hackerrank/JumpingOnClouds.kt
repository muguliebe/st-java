package codetest.hackerrank

import java.util.*

fun jumpingOnClouds(c: Array<Int>): Int {
    var jump = 1
    var step = 0

    while (step < c.size-3) {
        step += when {
            c[step + 1] == 0 && c[step + 2] == 1 -> 1
            else -> 2
        }
        jump++
    }

    return jump
}


fun main(args: Array<String>) {
//    val input = "0 1 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 1 0 1 0 1 0 0 0 0 0 1 0 0 1 0 1 0 0 1 0 1 0 1 0 0 0 0 1 0 0 1 0 0 1 0 1 0 0 1 0 1 0 0 1 0 1 0 1 0 1 0 0 0 1 0 1 0 0 0 1 0 1 0 0 0 1 0 1 0 1 0 0 0 0 1 0"
//    val input = "0 0 0 0 1 0"
    val input = "0 0 0 1 0 0"
    val c = input.trim().split(" ").map { it.toInt() }.toTypedArray()
    val result = jumpingOnClouds(c)
    println(result)
}
