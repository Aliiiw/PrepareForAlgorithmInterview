package leet_code.sliding_window.medium

import kotlin.math.max

fun main() {
    println(lengthOfLongestSubstring("alitest"))
}

fun lengthOfLongestSubstring(s: String): Int {
    if (s.length <= 1) return s.length

    val seenCharacters = hashMapOf<Char, Int>()
    var left = 0
    var right = 0
    var longest = 0

    for (i in s.indices) {
        if (seenCharacters.containsKey(s[i])) {
            left = max(left, seenCharacters[s[i]]!! + 1)
        }
        right++
        seenCharacters[s[i]] = i
        longest = max(right - left, longest)
    }

    return longest
}