package leet_code.intervals.medium


fun main() {
    print(
        findMinArrowShots(
            arrayOf(
                intArrayOf(10, 16),
                intArrayOf(2, 8),
                intArrayOf(1, 6),
                intArrayOf(7, 12),
            )
        )
    )
}

fun findMinArrowShots(points: Array<IntArray>): Int {
    if (points.isEmpty()) return 0

    points.sortWith(compareBy { it[1] })

    var arrows = 1
    var arrowX = points[0][1].toLong()

    for (i in 1 until points.size) {
        val start = points[i][0].toLong()
        val end = points[i][1].toLong()

        if (start > arrowX) {
            arrows++
            arrowX = end
        }
    }

    return arrows
}

