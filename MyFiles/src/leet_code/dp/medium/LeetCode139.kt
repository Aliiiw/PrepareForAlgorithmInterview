package leet_code.dp.medium


/**
Given a string s and a dictionary of strings wordDict,
return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */


fun main() {
    print(wordBreak("leetcode", listOf("leet", "code")))
}

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val dict = wordDict.toHashSet()
    val n = s.length

    var maxLen = 0
    for (w in wordDict) if (w.length > maxLen) maxLen = w.length

    val dp = BooleanArray(n + 1)
    dp[0] = true

    for (i in 1..n) {
        val start = maxOf(0, i - maxLen)
        var j = start
        while (j < i) {
            if (dp[j] && dict.contains(s.substring(j, i))) {
                dp[i] = true
                break
            }
            j++
        }
    }

    return dp[n]
}


