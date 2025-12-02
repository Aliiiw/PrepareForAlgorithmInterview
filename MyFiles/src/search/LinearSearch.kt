package search

fun linearSearch(nums: IntArray, target: Int): Int {
    for (i in nums.indices) {
        if (nums[i] == target) return i
    }
    return -1
}
