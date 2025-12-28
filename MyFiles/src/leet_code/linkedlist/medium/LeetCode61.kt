package leet_code.linkedlist.medium

import leet_code.linkedlist.easy.ListNode


/**
Given the head of a linked list, rotate the list to the right by k places.
 */


fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null || head.next == null || k == 0) return head

    var length = 1
    var tail = head
    while (tail?.next != null) {
        tail = tail.next
        length++
    }

    val rotate = k % length
    if (rotate == 0) return head

    tail?.next = head

    val stepsToNewTail = length - rotate - 1
    var newTail = head
    repeat(stepsToNewTail) {
        newTail = newTail?.next
    }

    val newHead = newTail?.next
    newTail?.next = null

    return newHead
}
