package leet_code.array_string.easy


fun main() {
    val test = "   fly me   to   the moon  "

    print(lengthOfLastWord2(test))

}

// v1
fun lengthOfLastWord(s: String): Int {
    return s.trim().split(" ").last().length
}

// v2
fun lengthOfLastWord2(s: String): Int {
    var i = s.length - 1
    while (i >= 0 && s[i] == ' ') i--
    var len = 0
    while (i >= 0 && s[i] != ' ') {
        len++
        i--
    }
    return len
}





