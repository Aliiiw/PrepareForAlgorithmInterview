package leet_code


fun main() {
    val test = intArrayOf(2, 3, 1, 1, 4)
    print(canJump4(test))
}

fun canJump(nums: IntArray): Boolean {
    return dfs(0, nums)
}

private fun dfs(i: Int, nums: IntArray): Boolean {
    if (i >= nums.size - 1) return true
    val maxJump = nums[i]

    for (step in 1..maxJump) {
        if (dfs(i + step, nums)) return true
    }
    return false
}


fun canJump2(nums: IntArray): Boolean {
    val memory = IntArray(nums.size) { -1 }
    return dfs(0, nums, memory)
}

private fun dfs(i: Int, nums: IntArray, memory: IntArray): Boolean {
    if (i >= nums.size - 1) return true
    if (memory[i] != -1) return memory[i] == 1

    val maxJump = nums[i]

    for (step in 1..maxJump) {
        if (dfs(i + step, nums, memory)) {
            memory[i] = 1
            return true
        }
    }
    memory[i] = 0
    return false
}


fun canJump3(nums: IntArray): Boolean {
    val n = nums.size
    val good = BooleanArray(n)
    good[n - 1] = true

    for (i in n - 2 downTo 0) {
        val far = minOf(n - 1, i + nums[i])
        var j = i + 1
        while (j <= far) {
            if (good[j]) {
                good[i] = true
                break
            }
            j++
        }
    }
    return good[0]
}


fun canJump4(nums: IntArray): Boolean {
    var farthest = 0
    val last = nums.size - 1

    for (i in nums.indices) {
        if (i > farthest) return false
        farthest = maxOf(farthest, i + nums[i])
        if (farthest >= last) return true
    }
    return true
}




