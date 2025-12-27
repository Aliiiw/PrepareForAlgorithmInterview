package leet_code.divide_conquer.hard

import leet_code.linkedlist.easy.ListNode
import java.util.*

/**
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
 */


fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val pq = PriorityQueue<ListNode> { a, b -> a.`val` - b.`val` }

    for (node in lists) {
        if (node != null) pq.add(node)
    }

    val dummy = ListNode(0)
    var tail = dummy

    while (pq.isNotEmpty()) {
        val node = pq.poll()
        tail.next = node
        tail = tail.next!!
        node.next?.let { pq.add(it) }
    }

    tail.next = null
    return dummy.next
}

fun mergeKLists2(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null

    fun merge(a: ListNode?, b: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var p1 = a
        var p2 = b

        while (p1 != null && p2 != null) {
            if (p1.`val` <= p2.`val`) {
                tail.next = p1
                p1 = p1.next
            } else {
                tail.next = p2
                p2 = p2.next
            }
            tail = tail.next!!
        }

        tail.next = p1 ?: p2
        return dummy.next
    }

    fun mergeRange(l: Int, r: Int): ListNode? {
        if (l == r) return lists[l]
        val mid = l + (r - l) / 2
        val left = mergeRange(l, mid)
        val right = mergeRange(mid + 1, r)
        return merge(left, right)
    }

    return mergeRange(0, lists.lastIndex)
}

