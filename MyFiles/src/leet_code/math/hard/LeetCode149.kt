package leet_code.math.hard

import kotlin.math.abs


/**
Given an array of points where points[i] = [xi, yi] represents a
point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 */


fun main() {
    print(
        maxPoints(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(3, 3),
            )
        )
    )
}


fun maxPoints(points: Array<IntArray>): Int {
    val n = points.size
    if (n <= 2) return n

    fun gcd(a0: Int, b0: Int): Int {
        var a = a0
        var b = b0
        while (b != 0) {
            val t = a % b
            a = b
            b = t
        }
        return a
    }

    var ans = 2

    for (i in 0 until n) {
        val map = HashMap<Long, Int>()
        var best = 0

        val xi = points[i][0]
        val yi = points[i][1]

        for (j in i + 1 until n) {
            var dx = points[j][0] - xi
            var dy = points[j][1] - yi

            if (dx == 0) {
                dy = 1
            } else if (dy == 0) {
                dx = 1
            } else {
                val g = gcd(abs(dx), abs(dy))
                dx /= g
                dy /= g
                if (dx < 0) {
                    dx = -dx
                    dy = -dy
                }
            }

            val key = (dy.toLong() shl 32) xor (dx.toLong() and 0xffffffffL)
            val cnt = (map[key] ?: 0) + 1
            map[key] = cnt
            if (cnt > best) best = cnt
        }

        val local = best + 1
        if (local > ans) ans = local
    }

    return ans
}




