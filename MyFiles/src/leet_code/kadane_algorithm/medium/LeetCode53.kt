package leet_code.kadane_algorithm.medium


/**
Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */


fun main() {
    print(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}

fun maxSubArray(nums: IntArray): Int {
    var cur = nums[0]
    var best = nums[0]

    for (i in 1 until nums.size) {
        val x = nums[i]
        cur = maxOf(x, cur + x)
        best = maxOf(best, cur)
    }

    return best
}

