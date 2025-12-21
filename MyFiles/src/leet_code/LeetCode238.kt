package leet_code

fun main() {
    val test = intArrayOf(1, 2, 3, 4)
    print(productExceptSelf(test).contentToString())
}

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val answer = IntArray(n)

    var prefix = 1
    for (i in 0 until n) {
        answer[i] = prefix
        prefix *= nums[i]
    }

    var suffix = 1
    for (i in n - 1 downTo 0) {
        answer[i] *= suffix
        suffix *= nums[i]
    }

    return answer
}