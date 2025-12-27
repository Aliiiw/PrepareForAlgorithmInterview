package leet_code.dp_multidimensional.medium


/**
Given two strings word1 and word2, return the minimum number
of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 */


fun main() {
    print(
        minDistance(
            "horse", "ros"
        )
    )
}

fun minDistance(word1: String, word2: String): Int {
    val n = word1.length
    val m = word2.length
    val dp = Array(n + 1) { IntArray(m + 1) }

    for (i in 0..n) dp[i][0] = i
    for (j in 0..m) dp[0][j] = j

    for (i in 1..n) {
        for (j in 1..m) {
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                val replace = dp[i - 1][j - 1] + 1
                val delete = dp[i - 1][j] + 1
                val insert = dp[i][j - 1] + 1
                dp[i][j] = minOf(replace, delete, insert)
            }
        }
    }

    return dp[n][m]
}

