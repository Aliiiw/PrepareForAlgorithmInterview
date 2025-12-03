package leet_code

fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
    val map = mutableMapOf<Int, Int>()

    for (a in nums1) {
        for (c in nums3) {
            val target = a + c
            if (map.containsKey(target).not()) {
                map[target] = 0
            }
            map[target] = map[target]!! + 1
        }
    }

    var result = 0
    for (b in nums2) {
        for (d in nums4) {
            val target = -(b + d)
            if (map.containsKey(target)) {
                result += map[target]!!
            }
        }
    }
    return result
}
