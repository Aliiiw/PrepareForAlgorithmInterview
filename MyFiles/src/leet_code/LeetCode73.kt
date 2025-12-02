package leet_code
fun setMatrixZero(matrix: Array<IntArray>) {
    val rows = matrix.size
    val columns = matrix[0].size

    val rowsWithZeros = mutableListOf<Int>()
    val columnsWithZeros = mutableListOf<Int>()

    for (row in 0 until rows) {
        for (col in 0 until columns) {
            if (matrix[row][col] == 0) {
                rowsWithZeros.add(row)
                columnsWithZeros.add(col)
            }
        }
    }

    for (row in 0 until rows) {
        for (col in 0 until columns) {
            if (row in rowsWithZeros && col in columnsWithZeros) {
                matrix[row][col] = 0
            }
        }
    }
}