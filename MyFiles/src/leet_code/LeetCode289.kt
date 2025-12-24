package leet_code


fun gameOfLife(board: Array<IntArray>) {
    val m = board.size
    val n = board[0].size

    val dirs = intArrayOf(-1, 0, 1)

    fun liveNeighbors(r: Int, c: Int): Int {
        var count = 0
        for (dr in dirs) {
            for (dc in dirs) {
                if (dr == 0 && dc == 0) continue
                val nr = r + dr
                val nc = c + dc
                if (nr in 0 until m && nc in 0 until n) {
                    val v = board[nr][nc]
                    if (v == 1 || v == 2) count++
                }
            }
        }
        return count
    }

    for (r in 0 until m) {
        for (c in 0 until n) {
            val neighbors = liveNeighbors(r, c)
            val cell = board[r][c]

            if (cell == 1) {
                if (neighbors < 2 || neighbors > 3) board[r][c] = 2
            } else {
                if (neighbors == 3) board[r][c] = 3
            }
        }
    }

    for (r in 0 until m) {
        for (c in 0 until n) {
            board[r][c] = when (board[r][c]) {
                2 -> 0
                3 -> 1
                else -> board[r][c]
            }
        }
    }
}

