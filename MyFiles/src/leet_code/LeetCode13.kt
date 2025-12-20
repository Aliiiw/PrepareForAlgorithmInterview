package leet_code


fun main() {
    print(romanToInt("MCMXCIV"))

}

// v1
fun romanToInt(s: String): Int {
    fun value(c: Char): Int = when (c) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }

    var result = 0
    var i = 0

    while (i < s.length) {
        val current = value(s[i])
        val next = if (i + 1 < s.length) value(s[i + 1]) else 0

        if (current < next) {
            result -= current
        } else {
            result += current
        }
        i++
    }

    return result
}
