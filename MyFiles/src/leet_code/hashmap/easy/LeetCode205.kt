package leet_code.hashmap.easy


fun main() {
    print(isIsomorphic("aaa", "aba"))
}


fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val st = HashMap<Char, Char>()
    val ts = HashMap<Char, Char>()

    for (i in s.indices) {
        val a = s[i]
        val b = t[i]

        val mappedB = st[a]
        if (mappedB != null && mappedB != b) return false

        val mappedA = ts[b]
        if (mappedA != null && mappedA != a) return false

        st[a] = b
        ts[b] = a
    }

    return true
}


