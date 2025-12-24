package leet_code.array_string.easy

fun main() {
    val nums = intArrayOf(1, 2, 2, 3, 3, 4, 5, 5, 6)
    val k = removeDuplicates(nums)
    print(k)
    print(" -> ")
    for (i in 0 until k) {
        print("${nums[i]} ")
    }
}

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var write = 1
    for (read in 1 until nums.size) {
        if (nums[read] != nums[write - 1]) {
            nums[write] = nums[read]
            write++
        }
    }
    return write
}
