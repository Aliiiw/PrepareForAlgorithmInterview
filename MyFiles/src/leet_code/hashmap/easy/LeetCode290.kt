package leet_code.hashmap.easy


fun main() {
    print(wordPattern("abba", "dog cat cat dog"))
}


fun wordPattern(pattern: String, s: String): Boolean {
    val words = s.split(" ")
    if (pattern.length != words.size) return false

    val pToW = HashMap<Char, String>()
    val wToP = HashMap<String, Char>()

    for (i in pattern.indices) {
        val p = pattern[i]
        val w = words[i]

        val mappedW = pToW[p]
        if (mappedW != null && mappedW != w) return false

        val mappedP = wToP[w]
        if (mappedP != null && mappedP != p) return false

        pToW[p] = w
        wToP[w] = p
    }

    return true
}
