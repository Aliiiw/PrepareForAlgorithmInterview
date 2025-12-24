package leet_code


fun main() {
    print(
        minWindow("ADOBECODEBANC", "ABC")
    )
}


fun minWindow(s: String, t: String): String {
    if (t.length > s.length) return ""

    val need = IntArray(128)
    for (ch in t) need[ch.code]++

    var required = 0
    for (i in 0 until 128) if (need[i] > 0) required++

    val window = IntArray(128)
    var formed = 0

    var left = 0
    var bestLen = Int.MAX_VALUE
    var bestStart = 0

    for (right in s.indices) {
        val rc = s[right].code
        window[rc]++

        if (need[rc] > 0 && window[rc] == need[rc]) {
            formed++
        }

        while (formed == required) {
            val len = right - left + 1
            if (len < bestLen) {
                bestLen = len
                bestStart = left
            }

            val lc = s[left].code
            window[lc]--
            if (need[lc] > 0 && window[lc] < need[lc]) {
                formed--
            }
            left++
        }
    }

    return if (bestLen == Int.MAX_VALUE) "" else s.substring(bestStart, bestStart + bestLen)
}
