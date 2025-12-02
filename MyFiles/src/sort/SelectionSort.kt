package sort

fun selectionSort(nums: IntArray) {
    val n = nums.size

    for (i in 0 until n) {
        var minIndex = i
        for (j in i + 1 until n) {
            if (nums[j] < nums[minIndex]) {
                minIndex = j
            }
        }
        val temp = nums[i]
        nums[i] = nums[minIndex]
        nums[minIndex] = temp
    }
}
