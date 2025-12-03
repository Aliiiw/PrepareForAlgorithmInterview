package leet_code

import kotlin.math.min

class MinStack() {

    private val stack = mutableListOf<Pair<Int, Int>>()

    fun push(x: Int) {
        var currentMin = x
        if (stack.isNotEmpty()) {
            val lastPosition = stack.size - 1
            currentMin = min(currentMin, stack[lastPosition].second)
        }
        stack.add(Pair(x, currentMin))
    }

    fun pop() {
        stack.removeAt(stack.size - 1)
    }

    fun top(): Int {
        if (stack.isEmpty()) {
            return -1
        }
        return stack[stack.size - 1].first
    }

    fun getMin(): Int {
        if (stack.isEmpty()) {
            return -1
        }
        return stack[stack.size - 1].second
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */