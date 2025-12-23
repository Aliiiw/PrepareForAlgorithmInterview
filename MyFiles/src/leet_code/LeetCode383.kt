package leet_code


fun main() {
    print(canConstruct("aaa", "aba"))
}


fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val count = IntArray(26)

    for (c in magazine) {
        count[c - 'a']++
    }

    for (c in ransomNote) {
        val idx = c - 'a'
        count[idx]--
        if (count[idx] < 0) return false
    }

    return true
}

