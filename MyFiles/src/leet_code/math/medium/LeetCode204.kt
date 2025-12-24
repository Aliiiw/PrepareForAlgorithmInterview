package leet_code.math.medium

import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {
    println(countPrimes(10))
}

fun countPrimes(n: Int): Int {
    if (n < 2) return 0

    val isPrime = BooleanArray(n) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2 until ceil(sqrt(n.toDouble())).toInt()) {
        if (isPrime[i]) {
            var moi = i * 2
            while (moi < n) {
                isPrime[moi] = false
                moi += i
            }
        }
    }
    var counter = 0
    for (i in 0 until n) {
        if (isPrime[i]) counter++
    }

    return counter
}