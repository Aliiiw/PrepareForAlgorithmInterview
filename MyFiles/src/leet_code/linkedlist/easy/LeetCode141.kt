package leet_code.linkedlist.easy

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun hasCycle(head: ListNode?): Boolean {
    var start = head
    var end = head

    while (end != null && end.next != null) {
        start = start?.next
        end = end.next?.next

        if (start == end) return true
    }
    return false
}