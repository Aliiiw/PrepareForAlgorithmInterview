package leet_code.binary_search.medium

/**
You are given an m x n integer matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
 */


fun main() {
    print(
        searchMatrix(
            arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 60)
            ),
            3
        )
    )
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size

    var l = 0
    var r = m * n - 1

    while (l <= r) {
        val mid = l + (r - l) / 2
        val v = matrix[mid / n][mid % n]

        if (v == target) return true
        if (v < target) l = mid + 1 else r = mid - 1
    }

    return false
}