package leet_code.sliding_window.medium


fun main() {
    print(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
}


fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var left = 0
    var sum = 0L
    var best = Int.MAX_VALUE

    for (right in nums.indices) {
        sum += nums[right].toLong()

        while (sum >= target.toLong()) {
            val len = right - left + 1
            if (len < best) best = len
            sum -= nums[left].toLong()
            left++
        }
    }

    return if (best == Int.MAX_VALUE) 0 else best
}



