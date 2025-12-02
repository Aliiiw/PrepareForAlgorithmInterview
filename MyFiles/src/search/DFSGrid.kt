package search

fun dfsGrid(
    grid: Array<IntArray>,
    rowIndex: Int,
    columnIndex: Int,
    visitedCells: Array<BooleanArray>,
) {
    val rowCount = grid.size
    val columnCount = grid[0].size

    if (rowIndex !in 0 until rowCount || columnIndex !in 0 until columnCount) return
    if (visitedCells[rowIndex][columnIndex]) return

    visitedCells[rowIndex][columnIndex] = true

    dfsGrid(grid, rowIndex + 1, columnIndex, visitedCells)
    dfsGrid(grid, rowIndex - 1, columnIndex, visitedCells)
    dfsGrid(grid, rowIndex, columnIndex + 1, visitedCells)
    dfsGrid(grid, rowIndex, columnIndex - 1, visitedCells)
}

