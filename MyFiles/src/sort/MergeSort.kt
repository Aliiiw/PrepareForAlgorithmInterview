package sort

fun mergeSort(nums: IntArray) {
    if (nums.size <= 1) return
    mergeSort(nums, 0, nums.size - 1)
}

private fun mergeSort(nums: IntArray, left: Int, right: Int) {
    if (left >= right) return
    val mid = left + (right - left) / 2
    mergeSort(nums, left, mid)
    mergeSort(nums, mid + 1, right)
    merge(nums, left, mid, right)
}

private fun merge(nums: IntArray, left: Int, mid: Int, right: Int) {
    val temp = IntArray(right - left + 1)
    var i = left
    var j = mid + 1
    var k = 0
    while (i <= mid && j <= right) {
        if (nums[i] <= nums[j]) {
            temp[k++] = nums[i++]
        } else {
            temp[k++] = nums[j++]
        }
    }
    while (i <= mid) {
        temp[k++] = nums[i++]
    }
    while (j <= right) {
        temp[k++] = nums[j++]
    }
    for (t in temp.indices) {
        nums[left + t] = temp[t]
    }
}
