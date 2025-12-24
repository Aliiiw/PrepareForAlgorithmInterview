package leet_code


fun main() {
    print(summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)))

}

fun summaryRanges(nums: IntArray): List<String> {
    val result = ArrayList<String>()
    if (nums.isEmpty()) return result

    var start = nums[0]
    var prev = nums[0]

    for (i in 1 until nums.size) {
        val currentNumber = nums[i]
        if (currentNumber.toLong() == prev.toLong() + 1L) {
            prev = currentNumber
        } else {
            if (start == prev) result.add(start.toString())
            else result.add("$start->$prev")
            start = currentNumber
            prev = currentNumber
        }
    }

    if (start == prev) result.add(start.toString())
    else result.add("$start->$prev")

    return result
}
