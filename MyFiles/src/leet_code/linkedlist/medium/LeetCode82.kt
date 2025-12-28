package leet_code.linkedlist.medium

import leet_code.linkedlist.easy.ListNode


/**
Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */


fun deleteDuplicates(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head

    var prevDistinct: ListNode? = dummy
    var current = head

    while (current != null) {
        val nextNode = current.next
        if (nextNode != null && nextNode.`val` == current.`val`) {
            val duplicatedValue = current.`val`
            while (current != null && current.`val` == duplicatedValue) {
                current = current.next
            }
            prevDistinct?.next = current
        } else {
            prevDistinct = current
            current = current.next
        }
    }

    return dummy.next
}
