package leet_code.linkedlist.hard

import leet_code.linkedlist.easy.ListNode


/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is
 not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 1) return head

    var n = 0
    var t = head
    while (t != null) {
        n++
        t = t.next
    }

    val dummy = ListNode(0)
    dummy.next = head

    var groupPrev: ListNode? = dummy
    var cur: ListNode? = head
    var groups = n / k

    while (groups > 0) {
        var prev: ListNode? = null
        val groupTail = cur

        var i = 0
        while (i < k) {
            val next = cur!!.next
            cur.next = prev
            prev = cur
            cur = next
            i++
        }

        groupPrev!!.next = prev
        groupTail!!.next = cur
        groupPrev = groupTail

        groups--
    }

    return dummy.next
}


fun reverseKGroup2(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 1) return head

    val dummy = ListNode(0)
    dummy.next = head

    var groupPrev: ListNode? = dummy

    while (true) {
        var kth: ListNode? = groupPrev
        var i = 0
        while (i < k && kth != null) {
            kth = kth.next
            i++
        }
        if (kth == null) break

        val groupNext = kth.next
        var prev: ListNode? = groupNext
        var cur = groupPrev!!.next

        var j = 0
        while (j < k) {
            val next = cur!!.next
            cur.next = prev
            prev = cur
            cur = next
            j++
        }

        val newGroupHead = prev
        val newGroupTail = groupPrev.next

        groupPrev.next = newGroupHead
        groupPrev = newGroupTail
    }

    return dummy.next
}
