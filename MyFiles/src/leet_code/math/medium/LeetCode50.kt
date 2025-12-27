package leet_code.math.medium


/**
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */


fun main() {
    print(myPow2(12.0, 3))
}

fun myPow(x: Double, n: Int): Double {
    var base = x
    var exp = n.toLong()
    var result = 1.0

    if (exp < 0) {
        base = 1 / base
        exp = -exp
    }

    while (exp > 0) {
        if ((exp and 1L) == 1L) {
            result *= base
        }
        base *= base
        exp = exp shr 1
    }

    return result
}

fun myPow2(x: Double, n: Int): Double {
    fun fastPow(base: Double, exp: Long): Double {
        if (exp == 0L) return 1.0
        val half = fastPow(base, exp / 2)
        return if (exp % 2 == 0L) {
            half * half
        } else {
            half * half * base
        }
    }

    return if (n >= 0) {
        fastPow(x, n.toLong())
    } else {
        1.0 / fastPow(x, -n.toLong())
    }
}
