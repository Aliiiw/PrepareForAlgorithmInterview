package leet_code.dp_multidimensional.medium


/**
Given an m x n binary matrix filled with 0's and 1's,
find the largest square containing only 1's and return its area.
 */


fun main() {
    print(
        maximalSquare(
            arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0')
            )
        )
    )
}

fun maximalSquare(matrix: Array<CharArray>): Int {
    val m = matrix.size
    val n = matrix[0].size
    val dp = Array(m + 1) { IntArray(n + 1) }
    var best = 0

    for (i in 1..m) {
        for (j in 1..n) {
            if (matrix[i - 1][j - 1] == '1') {
                dp[i][j] = 1 + minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
                if (dp[i][j] > best) best = dp[i][j]
            }
        }
    }

    return best * best
}
