package leet_code.dp.medium


/**
Given an integer array nums, return the
length of the longest strictly increasing subsequence.
 */


fun main() {
    print(lengthOfLIS(intArrayOf(1, 2, 3, 4)))
}

fun lengthOfLIS(nums: IntArray): Int {
    val n = nums.size
    val dp = IntArray(n) { 1 }
    var ans = 1

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (nums[j] < nums[i]) {
                val candidate = dp[j] + 1
                if (candidate > dp[i]) dp[i] = candidate
            }
        }
        if (dp[i] > ans) ans = dp[i]
    }

    return ans
}

fun lengthOfLIS2(nums: IntArray): Int {
    val tails = IntArray(nums.size)
    var size = 0

    for (x in nums) {
        var l = 0
        var r = size
        while (l < r) {
            val mid = l + (r - l) / 2
            if (tails[mid] < x) l = mid + 1 else r = mid
        }

        tails[l] = x
        if (l == size) size++
    }

    return size
}
