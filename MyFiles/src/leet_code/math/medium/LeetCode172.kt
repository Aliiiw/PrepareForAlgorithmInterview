package leet_code.math.medium


/**
Given an integer n, return the number of trailing zeroes in n!.
Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 */


fun main() {
    print(trailingZeroes(12))
}

fun trailingZeroes(n: Int): Int {
    var x = n
    var ans = 0
    while (x > 0) {
        x /= 5
        ans += x
    }
    return ans
}



