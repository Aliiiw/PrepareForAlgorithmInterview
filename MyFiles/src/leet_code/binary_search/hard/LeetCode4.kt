package leet_code.binary_search.hard

/**
Given two sorted arrays nums1 and nums2 of size m and n respectively,
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
 */


fun main() {
    print(
        findMedianSortedArrays(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
        )
    )
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var first = nums1
    var second = nums2

    if (first.size > second.size) {
        val tmp = first
        first = second
        second = tmp
    }

    val m = first.size
    val n = second.size
    var leftIndex = 0
    var rightIndex = m
    val leftSize = (m + n + 1) / 2

    while (leftIndex <= rightIndex) {
        val cutFirst = leftIndex + (rightIndex - leftIndex) / 2
        val cutSecond = leftSize - cutFirst

        val maxLeftFirst = if (cutFirst == 0) Int.MIN_VALUE else first[cutFirst - 1]
        val minRightFirst = if (cutFirst == m) Int.MAX_VALUE else first[cutFirst]

        val maxLeftSecond = if (cutSecond == 0) Int.MIN_VALUE else second[cutSecond - 1]
        val minRightSecond = if (cutSecond == n) Int.MAX_VALUE else second[cutSecond]

        val leftOk = maxLeftFirst <= minRightSecond
        val rightOk = maxLeftSecond <= minRightFirst

        if (leftOk && rightOk) {
            val maxLeft = maxOf(maxLeftFirst, maxLeftSecond)
            if ((m + n) % 2 == 1) return maxLeft.toDouble()
            val minRight = minOf(minRightFirst, minRightSecond)
            return (maxLeft.toLong() + minRight.toLong()) / 2.0
        }

        if (maxLeftFirst > minRightSecond) {
            rightIndex = cutFirst - 1
        } else {
            leftIndex = cutFirst + 1
        }
    }

    return 0.0
}

