package leet_code

fun majorityElement(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    val n = nums.size

    for (i in 0 until n) {
        if (map.containsKey(nums[i])) {
            map[nums[i]] = map[nums[i]]!! + 1

        } else {
            map[nums[i]] = 1
        }
    }

    var majority = 0
    for (i in 0 until n) {
        if (map[nums[i]]!! > n / 2) {
            majority = nums[i]
        }
    }
    return majority
}