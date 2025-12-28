package leet_code.graph_general.medium

/**
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells
if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with
'X's in-place within the original board. You do not need to return anything.
 */


fun solve(board: Array<CharArray>) {
    val m = board.size
    val n = board[0].size
    val q = ArrayDeque<Int>()

    fun add(i: Int, j: Int) {
        if (i < 0 || i >= m || j < 0 || j >= n) return
        if (board[i][j] != 'O') return
        board[i][j] = 'T'
        q.addLast(i * n + j)
    }

    for (j in 0 until n) {
        add(0, j)
        add(m - 1, j)
    }
    for (i in 0 until m) {
        add(i, 0)
        add(i, n - 1)
    }

    while (q.isNotEmpty()) {
        val x = q.removeFirst()
        val r = x / n
        val c = x % n
        add(r - 1, c)
        add(r + 1, c)
        add(r, c - 1)
        add(r, c + 1)
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (board[i][j] == 'O') board[i][j] = 'X'
            else if (board[i][j] == 'T') board[i][j] = 'O'
        }
    }
}

