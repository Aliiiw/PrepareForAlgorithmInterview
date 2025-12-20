package leet_code


fun main() {
    val test = intArrayOf(2, 2, 1, 1, 1, 2, 2)
    print(majorityElement2(test))
}

// v1
fun majorityElement(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    val n = nums.size

    for (i in 0 until n) {
        if (map.containsKey(nums[i])) {
            map[nums[i]] = map[nums[i]]!! + 1

        } else {
            map[nums[i]] = 1
        }
    }

    var majority = 0
    for (i in 0 until n) {
        if (map[nums[i]]!! > n / 2) {
            majority = nums[i]
        }
    }
    return majority
}

// v2
fun majorityElement2(nums: IntArray): Int {

    if (nums.isEmpty()) return 0

    var candidate = 0
    var counter = 0

    nums.forEach { number ->
        if (counter == 0) {
            candidate = number
        }
        if (number == candidate) counter++
        else counter--
    }

    return candidate
}