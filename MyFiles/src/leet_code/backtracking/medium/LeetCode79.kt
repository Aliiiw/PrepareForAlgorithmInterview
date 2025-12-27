package leet_code.backtracking.medium


/**
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.
 */


fun main() {
    print(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ),
            "ABCCED"
        )
    )
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    val m = board.size
    val n = board[0].size
    val w = word.toCharArray()

    fun dfs(r: Int, c: Int, idx: Int): Boolean {
        if (board[r][c] != w[idx]) return false
        if (idx == w.lastIndex) return true

        val ch = board[r][c]
        board[r][c] = '\u0000'

        val ok =
            (r > 0 && board[r - 1][c] != '\u0000' && dfs(r - 1, c, idx + 1)) ||
                    (r + 1 < m && board[r + 1][c] != '\u0000' && dfs(r + 1, c, idx + 1)) ||
                    (c > 0 && board[r][c - 1] != '\u0000' && dfs(r, c - 1, idx + 1)) ||
                    (c + 1 < n && board[r][c + 1] != '\u0000' && dfs(r, c + 1, idx + 1))

        board[r][c] = ch
        return ok
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (board[i][j] == w[0] && dfs(i, j, 0)) return true
        }
    }

    return false
}
