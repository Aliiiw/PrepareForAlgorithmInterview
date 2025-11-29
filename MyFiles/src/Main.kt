import java.util.PriorityQueue

fun main() {
    println(findKthLargest(intArrayOf(5, 6, 3, 4, 4, 2, 2, 5, 345, 45, 2, 342, 35, 2342), 1))
}


fun findKthLargest(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>()
    nums.forEach { num ->
        minHeap.add(num)

        if (minHeap.size > k) {
            minHeap.poll()
        }
    }
    return minHeap.peek()
}

//fun findKthLargest(nums: IntArray, k: Int): Int {
//    nums.sort()
//    return nums[nums.size - k]
//}

//fun rotate(nums: IntArray, k: Int): Unit {
//    val n = nums.size
//    if (n == 0) return
//
//    val result = IntArray(n)
//    val step = k % n
//
//    for (i in 0 until n) {
//        val newIndex = (i + step) % n
//        result[newIndex] = nums[i]
//    }
//
//    for (i in 0 until n) {
//        nums[i] = result[i]
//    }
//
//}

//fun reverseString(s: CharArray): Unit {
//    var left = 0
//    var right = s.size - 1
//
//    while (left < right) {
//        val temp = s[left]
//        s[left] = s[right]
//        s[right] = temp
//        left++
//        right--
//    }
//}
//
//fun reverseString(s: CharArray): Unit {
//    val result = mutableListOf<String>()
//    for(i in s.size - 1 downTo 0) {
//        result.add(s[i].toString())
//    }
//    println(result)
//}
//
//fun fizzBuzz(n: Int): List<String> {
//    val items = mutableListOf<String>()
//    for (i in 1..n) {
//        if (i % 15 == 0)
//            items.add("FizzBuzz")
//        else if (i % 3 == 0)
//            items.add("Fizz")
//        else if (i % 5 == 0)
//            items.add("Buzz")
//        else items.add(i.toString())
//    }
//    return items
//}

