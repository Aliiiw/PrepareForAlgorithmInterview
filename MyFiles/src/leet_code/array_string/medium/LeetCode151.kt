package leet_code.array_string.medium


fun main() {
    val test = "Hello World"
    print(reverseWords(test))
}


fun reverseWords(s: String): String {
    return s.trim()
        .split(Regex("\\s+"))
        .asReversed()
        .joinToString(" ")
}

fun reverseWords2(s: String): String {
    val parts = s.trim().split(' ').filter { it.isNotEmpty() }.asReversed()
    return parts.joinToString(" ")
}

fun reverseWords3(s: String): String {
    val sb = StringBuilder()
    var i = s.length - 1

    while (i >= 0) {
        while (i >= 0 && s[i] == ' ') i--
        if (i < 0) break

        var j = i
        while (j >= 0 && s[j] != ' ') j--

        if (sb.isNotEmpty()) sb.append(' ')
        sb.append(s.substring(j + 1, i + 1))

        i = j - 1
    }

    return sb.toString()
}

fun reverseWords4(s: String): String {
    return s.trim()
        .split(' ')
        .filter { it.isNotEmpty() }
        .asReversed()
        .joinToString(" ")
}

