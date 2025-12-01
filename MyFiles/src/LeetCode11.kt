import kotlin.math.max
import kotlin.math.min

fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var maxArea = 0

    while (left < right) {
        val length = min(height[left], height[right])
        val width = right - left
        val area = length * width
        maxArea = max(maxArea, area)
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return maxArea
}