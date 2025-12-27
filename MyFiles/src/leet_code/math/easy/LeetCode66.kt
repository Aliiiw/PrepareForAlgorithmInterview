package leet_code.math.easy


/**
You are given a large integer represented as an integer array digits,
where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
 */


fun main() {
    print(plusOne(intArrayOf(1, 2, 3)).contentToString())
}


fun plusOne(digits: IntArray): IntArray {
    val a = digits.copyOf()
    var i = a.lastIndex

    while (i >= 0) {
        if (a[i] < 9) {
            a[i]++
            return a
        }
        a[i] = 0
        i--
    }

    val res = IntArray(a.size + 1)
    res[0] = 1
    return res
}

fun plusOne2(digits: IntArray): IntArray {
    var i = digits.lastIndex

    while (i >= 0) {
        if (digits[i] < 9) {
            digits[i]++
            return digits
        }
        digits[i] = 0
        i--
    }

    val res = IntArray(digits.size + 1)
    res[0] = 1
    return res
}

