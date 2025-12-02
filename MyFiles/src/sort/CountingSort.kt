package sort

fun countingSort(numbers: IntArray, maxValue: Int): IntArray {
    val frequency = IntArray(maxValue + 1)
    for (value in numbers) {
        frequency[value]++
    }

    val sortedNumbers = IntArray(numbers.size)
    var sortedIndex = 0

    for (value in 0..maxValue) {
        var remainingCount = frequency[value]
        while (remainingCount > 0) {
            sortedNumbers[sortedIndex] = value
            sortedIndex++
            remainingCount--
        }
    }

    return sortedNumbers
}
