package search

fun binarySearch(sortedNumbers: IntArray, targetValue: Int): Int {
    var leftIndex = 0
    var rightIndex = sortedNumbers.size - 1

    while (leftIndex <= rightIndex) {
        val middleIndex = leftIndex + (rightIndex - leftIndex) / 2
        val middleValue = sortedNumbers[middleIndex]

        if (middleValue == targetValue) return middleIndex

        if (middleValue < targetValue) {
            leftIndex = middleIndex + 1
        } else {
            rightIndex = middleIndex - 1
        }
    }

    return -1
}
