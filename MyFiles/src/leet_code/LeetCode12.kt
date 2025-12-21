package leet_code


fun main() {
    print(intToRoman(58))

}


fun intToRoman(num: Int): String {
    val values = intArrayOf(
        1000, 900, 500, 400,
        100, 90, 50, 40,
        10, 9, 5, 4,
        1
    )
    val symbols = arrayOf(
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV",
        "I"
    )

    var n = num
    val result = StringBuilder()

    for (i in values.indices) {
        while (n >= values[i]) {
            n -= values[i]
            result.append(symbols[i])
        }
    }

    return result.toString()
}


