package leet_code.dp_multidimensional.medium


/**
You are given an m x n integer array grid.
There is a robot initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid.
A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 */

fun main() {
    print(
        uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0)
            )
        )
    )
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size
    val dp = Array(m) { IntArray(n) }

    if (obstacleGrid[0][0] == 1) return 0
    dp[0][0] = 1

    for (j in 1 until n) {
        dp[0][j] = if (obstacleGrid[0][j] == 1) 0 else dp[0][j - 1]
    }

    for (i in 1 until m) {
        dp[i][0] = if (obstacleGrid[i][0] == 1) 0 else dp[i - 1][0]
    }

    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[i][j] = if (obstacleGrid[i][j] == 1) 0 else dp[i - 1][j] + dp[i][j - 1]
        }
    }

    return dp[m - 1][n - 1]
}

