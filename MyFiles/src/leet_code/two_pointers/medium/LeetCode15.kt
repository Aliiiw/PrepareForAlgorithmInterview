package leet_code.two_pointers.medium

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val res = ArrayList<List<Int>>()
    val n = nums.size

    for (i in 0 until n - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) continue

        if (nums[i] > 0) break

        var left = i + 1
        var right = n - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            when {
                sum == 0 -> {
                    res.add(listOf(nums[i], nums[left], nums[right]))

                    val lv = nums[left]
                    val rv = nums[right]
                    while (left < right && nums[left] == lv) left++
                    while (left < right && nums[right] == rv) right--
                }

                sum < 0 -> left++
                else -> right--
            }
        }
    }

    return res
}