package leet_code.binary_search.medium

/**
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered
to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.
 */


fun main() {
    print(findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
}

fun findPeakElement(nums: IntArray): Int {
    var left = 0
    var right = nums.lastIndex

    while (left < right) {
        val middle = left + (right - left) / 2

        if (nums[middle] < nums[middle + 1]) {
            left = middle + 1
        } else {
            right = middle
        }
    }

    return left
}
