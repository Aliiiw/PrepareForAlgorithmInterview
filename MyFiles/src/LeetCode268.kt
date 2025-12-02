
fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    var sum = 0
    for (i in 0 until n) {
        sum += nums[i]
    }
    val allSum = n * (n + 1) / 2
    return allSum - sum
}
