package leet_code.divide_conquer.medium

import leet_code.linkedlist.easy.ListNode


/**
Given the head of a linked list, return the list after sorting it in ascending order.
 */

fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var slow: ListNode? = head
    var fast: ListNode? = head
    var prev: ListNode? = null

    while (fast != null && fast.next != null) {
        prev = slow
        slow = slow!!.next
        fast = fast.next!!.next
    }

    prev!!.next = null

    val left = sortList(head)
    val right = sortList(slow)

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

    return merge(left, right)
}

fun sortList2(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    fun length(node: ListNode?): Int {
        var cur = node
        var n = 0
        while (cur != null) {
            n++
            cur = cur.next
        }
        return n
    }

    fun split(start: ListNode?, size: Int): ListNode? {
        var cur = start
        var i = 1
        while (cur != null && i < size) {
            cur = cur.next
            i++
        }
        val second = cur?.next
        cur?.next = null
        return second
    }

    fun merge(a: ListNode?, b: ListNode?): Pair<ListNode?, ListNode?> {
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
        while (tail.next != null) tail = tail.next!!
        return Pair(dummy.next, tail)
    }

    val n = length(head)
    val dummy = ListNode(0)
    dummy.next = head

    var size = 1
    while (size < n) {
        var cur = dummy.next
        var tail: ListNode = dummy

        while (cur != null) {
            val left = cur
            val right = split(left, size)
            cur = split(right, size)

            val (mergedHead, mergedTail) = merge(left, right)
            tail.next = mergedHead
            tail = mergedTail ?: tail
        }

        size = size shl 1
    }

    return dummy.next
}
