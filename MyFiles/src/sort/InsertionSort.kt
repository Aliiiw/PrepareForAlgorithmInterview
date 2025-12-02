package sort

fun insertionSort(nums: IntArray) {
    val n = nums.size
    for (i in 1 until n) {
        val key = nums[i]
        var j = i - 1
        while (j >= 0 && nums[j] > key) {
            nums[j + 1] = nums[j]
            j--
        }
        nums[j + 1] = key
    }
}
