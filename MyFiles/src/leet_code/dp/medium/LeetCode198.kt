package leet_code.dp.medium

fun rob(nums: IntArray): Int {
    val n = nums.size

    if (n == 1) return nums[0]

    var house1 = nums[0]
    var house2 = maxOf(house1, nums[1])
    var ans = house2

    for (i in 2 until n) {
        ans = maxOf(house2, nums[i] + house1)
        house1 = house2
        house2 = ans
    }
    return ans
}