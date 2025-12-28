package leet_code.binary_search.medium

/**
Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]]
1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
 */


fun main() {
    print(findMin(intArrayOf(3, 4, 5, 1, 2)))
}

fun findMin(nums: IntArray): Int {
    var leftIndex = 0
    var rightIndex = nums.lastIndex

    while (leftIndex < rightIndex) {
        val midIndex = leftIndex + (rightIndex - leftIndex) / 2

        if (nums[midIndex] > nums[rightIndex]) {
            leftIndex = midIndex + 1
        } else {
            rightIndex = midIndex
        }
    }

    return nums[leftIndex]
}
