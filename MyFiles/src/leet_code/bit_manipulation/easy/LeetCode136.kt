package leet_code.bit_manipulation.easy

fun main() {
    println(singleNumber2(intArrayOf(1, 1, 2, 2, 4)))
}

fun singleNumber(nums: IntArray): Int {
    return (2 * nums.toSet().sum() - nums.sum())
}

fun singleNumber2(nums: IntArray): Int {
    var result = 0
    for (number in nums) result = result xor number
    return result
}
