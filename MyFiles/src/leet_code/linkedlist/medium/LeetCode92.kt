package leet_code.linkedlist.medium

import leet_code.linkedlist.easy.ListNode


/*
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.
 */

fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    if (head == null || left == right) return head

    val dummy = ListNode(0)
    dummy.next = head

    var prev: ListNode? = dummy
    var pos = 1
    while (pos < left) {
        prev = prev!!.next
        pos++
    }

    val prevLeft = prev
    var cur = prevLeft!!.next
    var prevNode: ListNode? = null

    var count = right - left + 1
    while (count > 0) {
        val next = cur!!.next
        cur.next = prevNode
        prevNode = cur
        cur = next
        count--
    }

    val start = prevLeft.next
    prevLeft.next = prevNode
    start!!.next = cur

    return dummy.next
}

fun reverseBetween2(head: ListNode?, left: Int, right: Int): ListNode? {
    if (head == null || left == right) return head

    val dummy = ListNode(0)
    dummy.next = head

    var prev: ListNode? = dummy
    var pos = 1
    while (pos < left) {
        prev = prev!!.next
        pos++
    }

    val prevLeft = prev
    val curr = prevLeft!!.next

    var times = right - left
    while (times > 0) {
        val move = curr!!.next
        curr.next = move!!.next
        move.next = prevLeft.next
        prevLeft.next = move
        times--
    }

    return dummy.next
}

