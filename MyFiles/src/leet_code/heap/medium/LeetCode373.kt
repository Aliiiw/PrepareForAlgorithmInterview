package leet_code.heap.medium

import java.util.*


/**
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 */


fun main() {
    print(
        kSmallestPairs(intArrayOf(1, 7, 11), intArrayOf(2, 4, 6), 3)
    )
}

fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    if (k <= 0 || nums1.isEmpty() || nums2.isEmpty()) return emptyList()

    data class State(val i: Int, val j: Int, val sum: Long)

    val pq = PriorityQueue<State> { a, b ->
        when {
            a.sum < b.sum -> -1
            a.sum > b.sum -> 1
            else -> 0
        }
    }

    val limit = minOf(nums1.size, k)
    for (i in 0 until limit) {
        pq.add(State(i, 0, nums1[i].toLong() + nums2[0].toLong()))
    }

    val res = ArrayList<List<Int>>()
    var remaining = k

    while (remaining > 0 && pq.isNotEmpty()) {
        val cur = pq.poll()
        res.add(listOf(nums1[cur.i], nums2[cur.j]))
        remaining--

        val nj = cur.j + 1
        if (nj < nums2.size) {
            pq.add(State(cur.i, nj, nums1[cur.i].toLong() + nums2[nj].toLong()))
        }
    }

    return res
}

