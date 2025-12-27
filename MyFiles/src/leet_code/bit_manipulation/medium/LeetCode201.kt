package leet_code.bit_manipulation.medium


/**
Given two integers left and right that represent the range [left, right],
return the bitwise AND of all numbers in this range, inclusive.
 */


fun main() {
    print(rangeBitwiseAnd(5, 7))
}

fun rangeBitwiseAnd(left: Int, right: Int): Int {
    var l = left
    var r = right
    var shift = 0

    while (l < r) {
        l = l shr 1
        r = r shr 1
        shift++
    }

    return l shl shift
}

fun rangeBitwiseAnd2(left: Int, right: Int): Int {
    var r = right
    while (r > left) {
        r = r and (r - 1)
    }
    return r
}

