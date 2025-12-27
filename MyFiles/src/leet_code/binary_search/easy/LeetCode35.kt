package leet_code.binary_search.easy


/**
Given a sorted array of distinct integers and a target value,
return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */


fun main() {
    print(searchInsert(intArrayOf(1, 3, 5, 6), 5))
}


fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size

    while (left < right) {
        val middle = left + (right - left) / 2

        if (nums[middle] < target) {
            left = middle + 1
        } else {
            right = middle
        }
    }
    return left
}