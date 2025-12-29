package hacker_rank.array

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */

fun minimumBribes(q: Array<Int>) {
    var bribes = 0

    for (i in q.indices) {
        if (q[i] - (i + 1) > 2) {
            println("Too chaotic")
            return
        }
    }

    for (i in q.indices) {
        val start = maxOf(0, q[i] - 2)
        for (j in start until i) {
            if (q[j] > q[i]) bribes++
        }
    }

    println(bribes)
}


fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        minimumBribes(q)
    }
}
