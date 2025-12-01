fun main() {
    moveZeroes(intArrayOf(0, 1, 0, 3, 12))
}

fun moveZeroes(nums: IntArray) {
    val result = arrayListOf<Int>()
    var zeroCount = 0

    nums.forEach { item ->
        if (item != 0) {
            result.add(item)
        } else zeroCount++
    }
    for (i in 1..zeroCount) {
        result.add(0)
    }
    println(result)
}

fun moveZeroes2(nums: IntArray) {
    var insertPosition = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[insertPosition] = nums[i]
            insertPosition++
        }
    }
    while (insertPosition < nums.size) {
        nums[insertPosition] = 0
        insertPosition++
    }
}

