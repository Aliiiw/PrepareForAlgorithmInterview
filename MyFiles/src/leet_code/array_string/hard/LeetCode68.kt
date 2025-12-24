package leet_code.array_string.hard

fun main() {
    print(
        fullJustify(
            arrayOf("This", "is", "an", "example", "of", "text", "justification."),
            16
        )
    )
}

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val result = ArrayList<String>()
    var i = 0

    while (i < words.size) {
        var lineLen = words[i].length
        var j = i + 1

        while (j < words.size && lineLen + 1 + words[j].length <= maxWidth) {
            lineLen += 1 + words[j].length
            j++
        }

        val isLastLine = j == words.size
        val count = j - i

        val sb = StringBuilder()

        if (count == 1 || isLastLine) {
            sb.append(words[i])
            for (k in i + 1 until j) {
                sb.append(' ')
                sb.append(words[k])
            }
            while (sb.length < maxWidth) sb.append(' ')
        } else {
            var wordsLen = 0
            for (k in i until j) wordsLen += words[k].length

            val totalSpaces = maxWidth - wordsLen
            val gaps = count - 1
            val base = totalSpaces / gaps
            var extra = totalSpaces % gaps

            for (k in i until j - 1) {
                sb.append(words[k])

                val spaces = base + if (extra > 0) 1 else 0
                repeat(spaces) { sb.append(' ') }
                if (extra > 0) extra--
            }
            sb.append(words[j - 1])
        }

        result.add(sb.toString())
        i = j
    }

    return result
}
