package leet_code.matrix.medium


fun rotate(matrix: Array<IntArray>) {
    val n = matrix.size

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = tmp
        }
    }

    for (i in 0 until n) {
        var l = 0
        var r = n - 1
        while (l < r) {
            val tmp = matrix[i][l]
            matrix[i][l] = matrix[i][r]
            matrix[i][r] = tmp
            l++
            r--
        }
    }
}

fun rotate2(matrix: Array<IntArray>) {
    val n = matrix.size
    var layer = 0

    while (layer < n / 2) {
        val first = layer
        val last = n - 1 - layer

        for (i in first until last) {
            val offset = i - first

            val top = matrix[first][i]
            matrix[first][i] = matrix[last - offset][first]
            matrix[last - offset][first] = matrix[last][last - offset]
            matrix[last][last - offset] = matrix[i][last]
            matrix[i][last] = top
        }

        layer++
    }
}

