package leet_code.array_string.medium

fun rotate(nums: IntArray, k: Int) {
    val n = nums.size
    if (n == 0) return

    val result = IntArray(n)
    val step = k % n

    for (i in 0 until n) {
        val newIndex = (i + step) % n
        result[newIndex] = nums[i]
    }

    for (i in 0 until n) {
        nums[i] = result[i]
    }
}