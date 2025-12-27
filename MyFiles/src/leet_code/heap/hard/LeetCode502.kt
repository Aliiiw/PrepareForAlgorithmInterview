package leet_code.heap.hard

import java.util.*


/**
Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares
to Venture Capital, LeetCode would like to work on some projects to increase
its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects
before the IPO. Help LeetCode design the best way to maximize its total capital after
finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit profits[i] and
a minimum capital of capital[i] is needed to start it.

Initially, you have w capital. When you finish a project, you will obtain its
pure profit and the profit will be added to your total capital.

Pick a list of at most k distinct projects from given projects to
maximize your final capital, and return the final maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.
 */

fun main() {
    print(findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1)))
}

fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    val n = profits.size
    val projects = Array(n) { i -> intArrayOf(capital[i], profits[i]) }
    projects.sortBy { it[0] }

    val maxProfit = PriorityQueue<Int>(compareByDescending { it })

    var curW = w
    var idx = 0
    var steps = 0

    while (steps < k) {
        while (idx < n && projects[idx][0] <= curW) {
            maxProfit.add(projects[idx][1])
            idx++
        }

        if (maxProfit.isEmpty()) break

        curW += maxProfit.poll()
        steps++
    }

    return curW
}

