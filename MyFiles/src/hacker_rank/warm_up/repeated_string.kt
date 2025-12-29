package hacker_rank.warm_up

import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*
import kotlin.text.iterator

/*
 * Complete the 'repeatedString' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. LONG_INTEGER n
 */

fun repeatedString(s: String, n: Long): Long {
    val len = s.length.toLong()

    var numberOfAInS = 0
    for (character in s) if (character == 'a') numberOfAInS++

    val fullString = n / len
    val remain = (n % len).toInt()

    var counterA = 0
    for (i in 0 until remain) if (s[i] == 'a') counterA++

    return fullString * numberOfAInS + counterA
}


fun main(args: Array<String>) {
    val s = readLine()!!

    val n = readLine()!!.trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
