package leet_code

fun searchRange(nums: IntArray, target: Int): IntArray {
    val first = findFirst(nums, target)
    val last = findLast(nums, target)
    return intArrayOf(first, last)
}


fun findFirst(nums: IntArray, target: Int): Int {
    for (i in 0..nums.size - 1) {
        if (nums[i] == target) return i
    }
    return -1
}

fun findLast(nums: IntArray, target: Int): Int {
    for (i in nums.size - 1 downTo 0) {
        if (nums[i] == target) return i
    }
    return -1
}
