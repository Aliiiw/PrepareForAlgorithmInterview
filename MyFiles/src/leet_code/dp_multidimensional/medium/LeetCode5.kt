package leet_code.dp_multidimensional.medium


/**
Given a string s, return the longest palindromic substring in s.
 */


fun main() {
    print(
        longestPalindrome("babad")
    )
}

fun longestPalindrome(s: String): String {
    val n = s.length
    if (n < 2) return s

    val dp = Array(n) { BooleanArray(n) }
    var bestL = 0
    var bestLen = 1

    for (r in 0 until n) {
        dp[r][r] = true
        for (l in 0 until r) {
            if (s[l] == s[r] && (r - l <= 2 || dp[l + 1][r - 1])) {
                dp[l][r] = true
                val len = r - l + 1
                if (len > bestLen) {
                    bestLen = len
                    bestL = l
                }
            }
        }
    }

    return s.substring(bestL, bestL + bestLen)
}

