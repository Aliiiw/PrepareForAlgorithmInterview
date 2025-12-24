package leet_code.array_string.medium

import kotlin.text.iterator


fun main() {
    val s = "PAYPALISHIRING"
    val numRows = 3
    print(convert(s, numRows))

}


fun convert(s: String, numRows: Int): String {
    if (numRows == 1 || numRows >= s.length) return s

    val rows = Array(numRows) { StringBuilder() }

    var row = 0
    var dir = 1

    for (ch in s) {
        rows[row].append(ch)

        if (row == 0) dir = 1
        else if (row == numRows - 1) dir = -1

        row += dir
    }

    val result = StringBuilder()
    for (sb in rows) result.append(sb)
    return result.toString()
}




