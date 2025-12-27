package leet_code.dp_multidimensional.medium


/**
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below.
More formally, if you are on index i on the current row,
you may move to either index i or index i + 1 on the next row.
 */


fun main() {
    print(
        minimumTotal(
            listOf(
                listOf(2),
                listOf(3, 4),
                listOf(6, 5, 7),
                listOf(4, 1, 8, 3)
            )
        )
    )
}

fun minimumTotal(triangle: List<List<Int>>): Int {
    val n = triangle.size
    val dp = Array(n) { IntArray(n) }

    dp[0][0] = triangle[0][0]

    for (r in 1 until n) {
        for (i in 0..r) {
            val valHere = triangle[r][i]
            val best = when (i) {
                0 -> dp[r - 1][0]
                r -> dp[r - 1][r - 1]
                else -> minOf(dp[r - 1][i - 1], dp[r - 1][i])
            }
            dp[r][i] = best + valHere
        }
    }

    var ans = dp[n - 1][0]
    for (i in 1 until n) ans = minOf(ans, dp[n - 1][i])
    return ans
}

fun minimumTotal2(triangle: List<List<Int>>): Int {
    val n = triangle.size
    val dp = IntArray(n)

    for (i in 0 until n) {
        dp[i] = triangle[n - 1][i]
    }

    for (r in n - 2 downTo 0) {
        for (i in 0..r) {
            dp[i] = triangle[r][i] + minOf(dp[i], dp[i + 1])
        }
    }

    return dp[0]
}
