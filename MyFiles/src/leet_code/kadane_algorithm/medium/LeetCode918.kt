package leet_code.kadane_algorithm.medium


/**
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally,
the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once.
Formally, for a subarray nums[i], nums[i + 1], ..., nums[j],
there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 */


fun main() {
    print(maxSubarraySumCircular(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}

fun maxSubarraySumCircular(nums: IntArray): Int {
    var total = 0

    var curMax = 0
    var maxSum = Int.MIN_VALUE

    var curMin = 0
    var minSum = Int.MAX_VALUE

    for (x in nums) {
        total += x

        curMax = maxOf(x, curMax + x)
        maxSum = maxOf(maxSum, curMax)

        curMin = minOf(x, curMin + x)
        minSum = minOf(minSum, curMin)
    }

    if (maxSum < 0) return maxSum
    return maxOf(maxSum, total - minSum)
}


