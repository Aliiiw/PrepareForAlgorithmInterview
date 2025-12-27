package leet_code.bit_manipulation.medium


/**
Given an integer array nums where every element appears three times except for one,
which appears exactly once. Find the single element and return it.
You must implement a solution with a linear runtime complexity and use only constant extra space.
 */


fun main() {
    print(singleNumber(intArrayOf(2, 2, 3, 2)))
}

fun singleNumber(nums: IntArray): Int {
    var ans = 0

    for (b in 0 until 32) {
        var cnt = 0
        for (x in nums) {
            cnt += (x ushr b) and 1
        }
        if (cnt % 3 != 0) {
            ans = ans or (1 shl b)
        }
    }

    return ans
}


fun singleNumber2(nums: IntArray): Int {
    var ones = 0
    var twos = 0

    for (x in nums) {
        ones = ones xor x and twos.inv()
        twos = twos xor x and ones.inv()
    }

    return ones
}


