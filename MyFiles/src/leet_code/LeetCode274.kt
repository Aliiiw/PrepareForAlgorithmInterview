package leet_code


fun main() {
    val test = intArrayOf(0, 0, 2)
    print(hIndex(test))
}


fun hIndex(citations: IntArray): Int {
    val n = citations.size
    var best = 0

    for (h in 0..n) {
        var count = 0
        for (c in citations) {
            if (c >= h) count++
        }
        if (count >= h) best = h
    }

    return best
}


fun hIndex2(citations: IntArray): Int {
    citations.sort()
    val n = citations.size
    var best = 0

    for (i in 0 until n) {
        val h = n - i
        if (citations[i] >= h) {
            best = h
            break
        }
    }

    return best
}


fun hIndex3(citations: IntArray): Int {
    val n = citations.size
    val count = IntArray(n + 1)

    for (c in citations) {
        if (c >= n) count[n]++ else count[c]++
    }

    var papers = 0
    for (h in n downTo 0) {
        papers += count[h]
        if (papers >= h) return h
    }

    return 0
}







