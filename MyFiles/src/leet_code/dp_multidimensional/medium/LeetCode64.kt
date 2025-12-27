package leet_code.dp_multidimensional.medium


/**
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right,
which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
 */


fun main() {
    print(
        minPathSum(
            arrayOf(
                intArrayOf(1, 3, 1),
                intArrayOf(1, 5, 1),
                intArrayOf(4, 2, 1)
            )
        )
    )
}

fun minPathSum(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val dp = Array(m) { IntArray(n) }

    dp[0][0] = grid[0][0]

    for (j in 1 until n) dp[0][j] = dp[0][j - 1] + grid[0][j]
    for (i in 1 until m) dp[i][0] = dp[i - 1][0] + grid[i][0]

    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[i][j] = grid[i][j] + minOf(dp[i - 1][j], dp[i][j - 1])
        }
    }

    return dp[m - 1][n - 1]
}

fun minPathSum2(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val dp = IntArray(n)

    dp[0] = grid[0][0]
    for (j in 1 until n) dp[j] = dp[j - 1] + grid[0][j]

    for (i in 1 until m) {
        dp[0] += grid[i][0]
        for (j in 1 until n) {
            dp[j] = grid[i][j] + minOf(dp[j], dp[j - 1])
        }
    }

    return dp[n - 1]
}
