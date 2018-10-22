package demo.algorithm

fun isPrimeNumber(num: Int): Boolean {
    for (i in 2..num / 2) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    (1..10).toList()
            .parallelStream()
            .filter{isPrimeNumber(it)}
//            .collect(Collector)
}
