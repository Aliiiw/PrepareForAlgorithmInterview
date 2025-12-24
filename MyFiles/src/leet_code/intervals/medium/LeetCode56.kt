package leet_code.intervals.medium


fun main() {
    print(
        merge(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6), intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        )
    )
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortWith(compareBy({ it[0] }, { it[1] }))

    val res = ArrayList<IntArray>()
    var currentStart = intervals[0][0]
    var currentEnd = intervals[0][1]

    for (i in 1 until intervals.size) {
        val start = intervals[i][0]
        val end = intervals[i][1]

        if (start <= currentEnd) {
            if (end > currentEnd) currentEnd = end
        } else {
            res.add(intArrayOf(currentStart, currentEnd))
            currentStart = start
            currentEnd = end
        }
    }

    res.add(intArrayOf(currentStart, currentEnd))
    return res.toTypedArray()
}

