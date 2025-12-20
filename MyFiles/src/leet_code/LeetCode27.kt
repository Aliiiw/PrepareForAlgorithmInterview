package leet_code

fun main() {

    val nums = intArrayOf(3, 2, 2, 3)
    print(removeElement2(nums, 3))

}

// v1
fun removeElement(nums: IntArray, value: Int): Int {
    var counter = 0
    val result = arrayListOf<String>()

    nums.forEach { number ->
        if (number != value) {
            counter++
            result.add(number.toString())
        }
    }

    val numberOfValue = nums.size - counter
    repeat(numberOfValue) {
        result.add("_")
    }

    println(result)
    return counter
}

// v2
fun removeElement2(nums: IntArray, value: Int): Int {
    var write = 0

    for (index in nums.indices) {
        if (nums[index] != value) {
            nums[write] = nums[index]
            write++
        }
    }
    return write
}

