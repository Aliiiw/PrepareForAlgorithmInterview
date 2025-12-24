package leet_code.hashmap.easy

import kotlin.text.iterator


fun main() {
    print(isAnagram("anagram", "nagaram"))
}


fun isAnagram(s: String, t: String): Boolean {
    val array = s.toCharArray()
    val array2 = t.toCharArray()

    array.sort()
    array2.sort()

    return array.contentEquals(array2)
}


fun isAnagram2(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val count = IntArray(26)

    for (c in s) count[c - 'a']++
    for (c in t) {
        val i = c - 'a'
        count[i]--
        if (count[i] < 0) return false
    }

    return true
}
