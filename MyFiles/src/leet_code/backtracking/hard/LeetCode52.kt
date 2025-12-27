package leet_code.backtracking.hard


/**
The n-queens puzzle is the problem of placing n queens on an n x n
chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */


fun main() {
    print(totalNQueens(5))
}


fun totalNQueens(n: Int): Int {
    val cols = BooleanArray(n)
    val diag1 = BooleanArray(2 * n - 1)
    val diag2 = BooleanArray(2 * n - 1)

    var count = 0

    fun dfs(r: Int) {
        if (r == n) {
            count++
            return
        }

        for (c in 0 until n) {
            val d1 = r - c + (n - 1)
            val d2 = r + c
            if (cols[c] || diag1[d1] || diag2[d2]) continue

            cols[c] = true
            diag1[d1] = true
            diag2[d2] = true

            dfs(r + 1)

            cols[c] = false
            diag1[d1] = false
            diag2[d2] = false
        }
    }

    dfs(0)
    return count
}
