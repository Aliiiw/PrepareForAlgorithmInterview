package leet_code.intervals.medium


fun main() {
    print(
        insert(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(6, 9)
            ),
            intArrayOf(2, 5)
        )
    )
}

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val res = ArrayList<IntArray>()
    var start = newInterval[0]
    var end = newInterval[1]
    var i = 0
    val n = intervals.size

    while (i < n && intervals[i][1] < start) {
        res.add(intervals[i])
        i++
    }

    while (i < n && intervals[i][0] <= end) {
        start = minOf(start, intervals[i][0])
        end = maxOf(end, intervals[i][1])
        i++
    }

    res.add(intArrayOf(start, end))

    while (i < n) {
        res.add(intervals[i])
        i++
    }

    return res.toTypedArray()
}

