package leet_code.dp_multidimensional.medium


/**
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration
where s and t are divided into n and m substrings respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.
 */


fun main() {
    print(
        isInterleave(
            "aabcc",
            "dbbca",
            "aadbbcbcac"
        )
    )
}

fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    val n = s1.length
    val m = s2.length
    if (n + m != s3.length) return false

    val dp = Array(n + 1) { BooleanArray(m + 1) }
    dp[0][0] = true

    for (i in 1..n) {
        dp[i][0] = dp[i - 1][0] && s1[i - 1] == s3[i - 1]
    }
    for (j in 1..m) {
        dp[0][j] = dp[0][j - 1] && s2[j - 1] == s3[j - 1]
    }

    for (i in 1..n) {
        for (j in 1..m) {
            val k = i + j - 1
            val fromS1 = dp[i - 1][j] && s1[i - 1] == s3[k]
            val fromS2 = dp[i][j - 1] && s2[j - 1] == s3[k]
            dp[i][j] = fromS1 || fromS2
        }
    }

    return dp[n][m]
}
