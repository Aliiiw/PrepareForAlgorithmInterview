package leet_code.math.easy


/**
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */


fun main() {
    print(mySqrt(4))
}

fun mySqrt(x: Int): Int {
    if (x < 2) return x

    var l = 1
    var r = x / 2
    var ans = 1

    while (l <= r) {
        val mid = l + (r - l) / 2
        if (mid <= x / mid) {
            ans = mid
            l = mid + 1
        } else {
            r = mid - 1
        }
    }

    return ans
}

fun mySqrt2(x: Int): Int {
    if (x < 2) return x

    var r = x.toLong()
    while (r * r > x) {
        r = (r + x / r) / 2
    }

    return r.toInt()
}



