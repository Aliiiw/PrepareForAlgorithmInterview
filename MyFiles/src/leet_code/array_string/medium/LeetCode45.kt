package leet_code.array_string.medium


fun main() {
    val test = intArrayOf(2, 3, 1, 1, 4)
    print(jump(test))
}

fun jump(nums: IntArray): Int {
    if (nums.size <= 1) return 0

    var jumps = 0
    var end = 0
    var farthest = 0

    for (i in 0 until nums.size - 1) {
        farthest = maxOf(farthest, i + nums[i])
        if (i == end) {
            jumps++
            end = farthest
        }
    }
    return jumps
}

