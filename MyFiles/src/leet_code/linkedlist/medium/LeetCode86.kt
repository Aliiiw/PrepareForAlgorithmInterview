package leet_code.linkedlist.medium

import leet_code.linkedlist.easy.ListNode


/**
Given the head of a linked list and a value x, partition it such that all
nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
 */


/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */


fun partition(head: ListNode?, x: Int): ListNode? {
    val lessDummy = ListNode(0)
    val greaterDummy = ListNode(0)

    var lessTail: ListNode? = lessDummy
    var greaterTail: ListNode? = greaterDummy

    var current = head
    while (current != null) {
        val nextNode = current.next
        if (current.`val` < x) {
            lessTail?.next = current
            lessTail = current
        } else {
            greaterTail?.next = current
            greaterTail = current
        }
        current.next = null
        current = nextNode
    }

    lessTail?.next = greaterDummy.next
    return lessDummy.next
}


