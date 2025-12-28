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
    print(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
}

fun search(nums: IntArray, target: Int): Int {
    var leftIndex = 0
    var rightIndex = nums.lastIndex

    while (leftIndex <= rightIndex) {
        val midIndex = leftIndex + (rightIndex - leftIndex) / 2
        val midValue = nums[midIndex]

        if (midValue == target) return midIndex

        val leftValue = nums[leftIndex]
        val rightValue = nums[rightIndex]

        if (leftValue <= midValue) {
            val targetInLeftSortedPart = leftValue <= target && target < midValue
            if (targetInLeftSortedPart) {
                rightIndex = midIndex - 1
            } else {
                leftIndex = midIndex + 1
            }
        } else {
            val targetInRightSortedPart = midValue < target && target <= rightValue
            if (targetInRightSortedPart) {
                leftIndex = midIndex + 1
            } else {
                rightIndex = midIndex - 1
            }
        }
    }

    return -1
}



