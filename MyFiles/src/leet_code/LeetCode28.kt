package leet_code

fun main() {
    val haystack = "sadbutsad"
    val needle = "sad"
    print(strStr(haystack, needle))
}


fun strStr(haystack: String, needle: String): Int {
    return haystack.indexOf(needle)
}

fun strStr2(haystack: String, needle: String): Int {
    if (needle.isEmpty()) return 0
    if (haystack.length < needle.length) return -1

    val hLen = haystack.length
    val nLen = needle.length

    for (i in 0..(hLen - nLen)) {
        var j = 0
        while (j < nLen && haystack[i + j] == needle[j]) {
            j++
        }
        if (j == nLen) return i
    }
    return -1
}

