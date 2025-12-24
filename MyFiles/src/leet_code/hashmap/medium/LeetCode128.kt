package leet_code.hashmap.medium


fun main() {
    print(longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
}

fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    val set = HashSet<Int>(nums.size)
    for (x in nums) set.add(x)

    var best = 0

    for (x in set) {
        if (!set.contains(x - 1)) {
            var current = x
            var length = 1

            while (set.contains(current + 1)) {
                current++
                length++
            }

            if (length > best) best = length
        }
    }

    return best
}



