package search

import java.util.ArrayDeque

fun bfsGrid(grid: Array<IntArray>, startRow: Int, startColumn: Int) {
    val rowCount = grid.size
    val columnCount = grid[0].size

    val visitedCells = Array(rowCount) { BooleanArray(columnCount) }

    val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    val cellQueue = ArrayDeque<Pair<Int, Int>>()
    visitedCells[startRow][startColumn] = true
    cellQueue.add(Pair(startRow, startColumn))

    while (cellQueue.isNotEmpty()) {
        val (currentRow, currentColumn) = cellQueue.removeFirst()

        for (direction in directions) {
            val nextRow = currentRow + direction[0]
            val nextColumn = currentColumn + direction[1]

            if (
                nextRow in 0 until rowCount &&
                nextColumn in 0 until columnCount &&
                !visitedCells[nextRow][nextColumn]
            ) {
                visitedCells[nextRow][nextColumn] = true
                cellQueue.add(Pair(nextRow, nextColumn))
            }
        }
    }
}

