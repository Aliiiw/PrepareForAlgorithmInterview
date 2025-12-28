package leet_code.linkedlist.medium

import leet_code.linkedlist.easy.ListNode


/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */


fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head

    var length = 0
    var cur = head
    while (cur != null) {
        length++
        cur = cur.next
    }

    val stepsToPrev = length - n
    var prev: ListNode? = dummy
    repeat(stepsToPrev) {
        prev = prev?.next
    }

    prev?.next = prev.next?.next
    return dummy.next
}

fun removeNthFromEndTwoPointer(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head

    var fast: ListNode? = dummy
    var slow: ListNode? = dummy

    repeat(n) {
        fast = fast?.next
    }

    while (fast?.next != null) {
        fast = fast.next
        slow = slow?.next
    }

    slow?.next = slow.next?.next
    return dummy.next
}


