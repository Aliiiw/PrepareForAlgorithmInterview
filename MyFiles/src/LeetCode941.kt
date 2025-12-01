fun validMountainArray(arr: IntArray): Boolean {
    val arraySize = arr.size
    if (arraySize < 3) return false

    var i = 1
    while (i < arraySize && arr[i] > arr[i - 1]) i++
    if (i == 1 || i == arraySize) return false
    while (i < arraySize && arr[i] < arr[i - 1]) i++

    return i == arraySize
}
