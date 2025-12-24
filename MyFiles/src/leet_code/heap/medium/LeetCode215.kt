package leet_code.heap.medium

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

//fun leet_code.heap.medium.findKthLargest(nums: IntArray, k: Int): Int {
//    nums.sort()
//    return nums[nums.size - k]
//}