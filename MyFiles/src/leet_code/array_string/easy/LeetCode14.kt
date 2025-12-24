package leet_code.array_string.easy

fun main() {
    val strs = arrayOf("flower", "flow", "flight")
    print(longestCommonPrefix(strs))
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""

    var prefix = strs[0]
    for (i in 1 until strs.size) {
        while (!strs[i].startsWith(prefix)) {
            if (prefix.isEmpty()) return ""
            prefix = prefix.substring(0, prefix.length - 1)
        }
    }
    return prefix
}
