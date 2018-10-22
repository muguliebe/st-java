package codetest.hackerrank

import java.util.*

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    return ar.groupBy { it }
            .filter { it.value.size >= 2 }
            .map { it.value.size / 2 }
            .sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

//    val n = scan.nextLine().trim().toInt()
//    val ar = scan.nextLine().trim().split(" ").map { it.trim().toInt() }.toTypedArray()

    val input = "4 5 5 5 6 6 4 1 4 4 3 6 6 3 6 1 4 5 5 5 "
    val inArr = input.trim().split(" ")

    val n = inArr.size
    val ar = inArr.map { it.trim().toInt() }.toTypedArray()
    val result = sockMerchant(n, ar)

    println(result)
}
