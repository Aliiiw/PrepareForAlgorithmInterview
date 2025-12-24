package leet_code.array_string.medium

fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    print(removeDuplicatesII(nums))
}


fun removeDuplicatesII(nums: IntArray): Int {
    var write = 0

    for (number in nums) {
        if (write < 2 || number != nums[write - 2]) {
            nums[write] = number
            write++
        }
    }
    return write
}

