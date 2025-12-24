package leet_code.hashmap.easy


fun main() {
    print(containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val lastIndex = HashMap<Int, Int>()

    for (i in nums.indices) {
        val value = nums[i]
        val prev = lastIndex[value]
        if (prev != null && i - prev <= k) return true
        lastIndex[value] = i
    }

    return false
}
