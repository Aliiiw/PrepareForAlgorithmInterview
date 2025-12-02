package search

fun maxSumFixedWindow(numbers: IntArray, windowSize: Int): Int {
    var currentWindowSum = 0
    for (index in 0 until windowSize) {
        currentWindowSum += numbers[index]
    }

    var maximumWindowSum = currentWindowSum

    for (rightIndex in windowSize until numbers.size) {
        currentWindowSum += numbers[rightIndex]
        currentWindowSum -= numbers[rightIndex - windowSize]
        if (currentWindowSum > maximumWindowSum) {
            maximumWindowSum = currentWindowSum
        }
    }

    return maximumWindowSum
}

fun slidingWindowGeneral(
    numbers: IntArray,
    isWindowValid: (Int) -> Boolean,
): Int {
    var leftIndex = 0
    var bestWindowLength = 0
    var currentWindowValue = 0

    for (rightIndex in numbers.indices) {
        currentWindowValue += numbers[rightIndex]

        while (!isWindowValid(currentWindowValue) && leftIndex <= rightIndex) {
            currentWindowValue -= numbers[leftIndex]
            leftIndex++
        }

        val currentWindowLength = rightIndex - leftIndex + 1
        bestWindowLength = maxOf(bestWindowLength, currentWindowLength)
    }

    return bestWindowLength
}

