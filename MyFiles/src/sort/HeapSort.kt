package sort

fun heapSort(nums: IntArray) {
    val n = nums.size
    for (i in n / 2 - 1 downTo 0) {
        heapify(nums, n, i)
    }
    for (i in n - 1 downTo 0) {
        val temp = nums[0]
        nums[0] = nums[i]
        nums[i] = temp
        heapify(nums, i, 0)
    }
}

fun heapify(nums: IntArray, heapSize: Int, i: Int) {
    var largest = i
    val left = 2 * i + 1
    val right = 2 * i + 2
    if (left < heapSize && nums[left] > nums[largest]) {
        largest = left
    }
    if (right < heapSize && nums[right] > nums[largest]) {
        largest = right
    }
    if (largest != i) {
        val temp = nums[i]
        nums[i] = nums[largest]
        nums[largest] = temp
        heapify(nums, heapSize, largest)
    }
}
