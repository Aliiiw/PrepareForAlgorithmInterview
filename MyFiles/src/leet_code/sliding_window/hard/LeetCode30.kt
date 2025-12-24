package leet_code.sliding_window.hard


fun main() {
    print(findSubstring("barfoothefoobarman", arrayOf("foo", "bar")))
}


fun findSubstring(s: String, words: Array<String>): List<Int> {
    if (words.isEmpty()) return emptyList()

    val wordLen = words[0].length
    val wordsCount = words.size
    val windowLen = wordLen * wordsCount
    if (s.length < windowLen) return emptyList()

    val need = HashMap<String, Int>()
    for (w in words) need[w] = (need[w] ?: 0) + 1

    val result = ArrayList<Int>()

    for (offset in 0 until wordLen) {
        var left = offset
        var right = offset
        var matched = 0
        val window = HashMap<String, Int>()

        while (right + wordLen <= s.length) {
            val w = s.substring(right, right + wordLen)
            right += wordLen

            if (!need.containsKey(w)) {
                window.clear()
                matched = 0
                left = right
                continue
            }

            window[w] = (window[w] ?: 0) + 1
            matched++

            while (window[w]!! > need[w]!!) {
                val leftWord = s.substring(left, left + wordLen)
                window[leftWord] = window[leftWord]!! - 1
                matched--
                left += wordLen
            }

            if (matched == wordsCount) {
                result.add(left)

                val leftWord = s.substring(left, left + wordLen)
                window[leftWord] = window[leftWord]!! - 1
                matched--
                left += wordLen
            }
        }
    }

    return result
}

