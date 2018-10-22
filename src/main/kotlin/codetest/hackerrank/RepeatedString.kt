package codetest.hackerrank

fun repeatedString(s: String, n: Long): Long {
    var count = s.count { it == 'a' }
    var cuttedCount = s.substring(0, (n % s.length).toInt()).count { it == 'a' }
    return ((count * (n / s.length)) + cuttedCount)
}


fun main(args: Array<String>) {
    val s = "aa0000"
    val n = 30L
    val result = repeatedString(s, n)
    println(result)
}
