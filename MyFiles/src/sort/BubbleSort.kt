package sort

fun bubbleSort(nums: IntArray) {
    val n = nums.size
    for (i in 0 until n) {
        for (j in 0 until n - 1 - i) {
            if (nums[j] > nums[j + 1]) {
                val temp = nums[j]
                nums[j] = nums[j + 1]
                nums[j + 1] = temp
            }
        }
    }
}
