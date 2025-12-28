package leet_code.graph_general.medium

/**
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent
lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */


fun main() {
    print(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        )
    )
}

fun numIslands(grid: Array<CharArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var ans = 0
    val q = ArrayDeque<Int>()

    fun add(i: Int, j: Int) {
        if (i < 0 || i >= m || j < 0 || j >= n) return
        if (grid[i][j] != '1') return
        grid[i][j] = '0'
        q.addLast(i * n + j)
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == '1') {
                ans++
                add(i, j)
                while (q.isNotEmpty()) {
                    val x = q.removeFirst()
                    val r = x / n
                    val c = x % n
                    add(r - 1, c)
                    add(r + 1, c)
                    add(r, c - 1)
                    add(r, c + 1)
                }
            }
        }
    }
    return ans
}
