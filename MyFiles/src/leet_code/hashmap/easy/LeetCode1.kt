package leet_code.hashmap.easy

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        val num = nums[i]
        val remainder = target - num

        if (map.containsKey(remainder)) {
            return intArrayOf(map[remainder]!!, i)
        }

        map[num] = i
    }

    return intArrayOf()
}