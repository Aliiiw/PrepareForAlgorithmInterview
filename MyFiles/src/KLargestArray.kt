import java.util.PriorityQueue

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