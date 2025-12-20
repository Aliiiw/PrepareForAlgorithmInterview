package cracking_the_coding_interview.chapter1

/*
Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */

fun main() {
    val inputMatrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    val expectedMatrix = arrayOf(
        intArrayOf(7, 4, 1),
        intArrayOf(8, 5, 2),
        intArrayOf(9, 6, 3)
    )

    rotateMatrix90Clockwise(inputMatrix)

    val passed = matricesEqual(inputMatrix, expectedMatrix)
    println(passed)

    printMatrix(inputMatrix)
}

// v1
fun rotateMatrix90Clockwise(matrix: Array<IntArray>) {
    val size = matrix.size
    if (size == 0) return
    if (matrix.any { it.size != size }) return

    var layerStart = 0
    var layerEnd = size - 1

    while (layerStart < layerEnd) {
        for (offset in 0 until (layerEnd - layerStart)) {
            val topRowIndex = layerStart
            val topColumnIndex = layerStart + offset

            val rightRowIndex = layerStart + offset
            val rightColumnIndex = layerEnd

            val bottomRowIndex = layerEnd
            val bottomColumnIndex = layerEnd - offset

            val leftRowIndex = layerEnd - offset
            val leftColumnIndex = layerStart

            val topValue = matrix[topRowIndex][topColumnIndex]

            matrix[topRowIndex][topColumnIndex] = matrix[leftRowIndex][leftColumnIndex]
            matrix[leftRowIndex][leftColumnIndex] = matrix[bottomRowIndex][bottomColumnIndex]
            matrix[bottomRowIndex][bottomColumnIndex] = matrix[rightRowIndex][rightColumnIndex]
            matrix[rightRowIndex][rightColumnIndex] = topValue
        }

        layerStart++
        layerEnd--
    }
}

fun matricesEqual(firstMatrix: Array<IntArray>, secondMatrix: Array<IntArray>): Boolean {
    if (firstMatrix.size != secondMatrix.size) return false
    for (rowIndex in firstMatrix.indices) {
        if (!firstMatrix[rowIndex].contentEquals(secondMatrix[rowIndex])) return false
    }
    return true
}

fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        println(row.joinToString(prefix = "[", postfix = "]", separator = ", "))
    }
}
