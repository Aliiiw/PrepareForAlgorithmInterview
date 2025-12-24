package leet_code.matrix.medium


fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rows = Array(9) { BooleanArray(9) }
    val cols = Array(9) { BooleanArray(9) }
    val boxes = Array(9) { BooleanArray(9) }

    for (r in 0 until 9) {
        for (c in 0 until 9) {
            val ch = board[r][c]
            if (ch == '.') continue

            val d = ch - '1'
            val b = (r / 3) * 3 + (c / 3)

            if (rows[r][d] || cols[c][d] || boxes[b][d]) return false

            rows[r][d] = true
            cols[c][d] = true
            boxes[b][d] = true
        }
    }

    return true
}
