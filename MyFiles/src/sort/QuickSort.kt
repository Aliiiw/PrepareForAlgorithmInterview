package sort

fun quickSort(nums: IntArray) {
    if (nums.size <= 1) return
    quickSort(nums, 0, nums.size - 1)
}

fun quickSort(nums: IntArray, low: Int, high: Int) {
    if (low >= high) return
    val partition = partition(nums, low, high)
    quickSort(nums, low, partition - 1)
    quickSort(nums, partition + 1, high)
}

fun partition(nums: IntArray, low: Int, high: Int): Int {
    val pivot = nums[high]
    var i = low
    for (j in low until high) {
        if (nums[j] <= pivot) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i++
        }
    }
    val temp = nums[i]
    nums[i] = nums[high]
    nums[high] = temp
    return i
}
