package leet_code.bit_manipulation.easy

fun main() {
    println(singleNumber(intArrayOf(1, 1, 2, 2, 4)))
}

fun singleNumber(nums: IntArray): Int {
    return (2 * nums.toSet().sum() - nums.sum())
}