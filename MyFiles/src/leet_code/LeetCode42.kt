package leet_code


fun main() {
    val test = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    print(trap(test))
}


fun trap(height: IntArray): Int {
    val n = height.size
    var water = 0

    for (i in 0 until n) {
        var leftMax = 0
        for (l in 0..i) {
            if (height[l] > leftMax) leftMax = height[l]
        }

        var rightMax = 0
        for (r in i until n) {
            if (height[r] > rightMax) rightMax = height[r]
        }

        val level = minOf(leftMax, rightMax)
        if (level > height[i]) water += level - height[i]
    }

    return water
}

fun trapDP(height: IntArray): Int {
    val n = height.size
    if (n == 0) return 0

    val leftMax = IntArray(n)
    val rightMax = IntArray(n)

    leftMax[0] = height[0]
    for (i in 1 until n) {
        leftMax[i] = maxOf(leftMax[i - 1], height[i])
    }

    rightMax[n - 1] = height[n - 1]
    for (i in n - 2 downTo 0) {
        rightMax[i] = maxOf(rightMax[i + 1], height[i])
    }

    var water = 0
    for (i in 0 until n) {
        val level = minOf(leftMax[i], rightMax[i])
        if (level > height[i]) water += level - height[i]
    }

    return water
}

fun trapTwoPointers(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var leftMax = 0
    var rightMax = 0
    var water = 0

    while (left < right) {
        if (height[left] <= height[right]) {
            if (height[left] >= leftMax) {
                leftMax = height[left]
            } else {
                water += leftMax - height[left]
            }
            left++
        } else {
            if (height[right] >= rightMax) {
                rightMax = height[right]
            } else {
                water += rightMax - height[right]
            }
            right--
        }
    }

    return water
}
