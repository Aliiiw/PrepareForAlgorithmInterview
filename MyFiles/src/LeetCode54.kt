
fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    spiralOrder(matrix).forEach { print(" $it ") }
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val result = mutableListOf<Int>()

    if (matrix.isEmpty()) return result

    val m = matrix.size
    val n = matrix[0].size

    var top = 0
    var bottom = m - 1
    var left = 0
    var right = n - 1

    while (top <= bottom && left <= right) {

        for (col in left..right) {
            result.add(matrix[top][col])
        }
        top++

        for (row in top..bottom) {
            result.add(matrix[row][right])
        }
        right--

        if (top <= bottom) {
            for (col in right downTo left) {
                result.add(matrix[bottom][col])
            }
            bottom--
        }
        if (left <= right) {
            for (row in bottom downTo top) {
                result.add(matrix[row][left])
            }
            left++
        }
    }

    return result
}