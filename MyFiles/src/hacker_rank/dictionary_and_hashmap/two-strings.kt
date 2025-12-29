package hacker_rank.dictionary_and_hashmap

/*
 * Complete the 'twoStrings' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s1
 *  2. STRING s2
 */


fun twoStrings(s1: String, s2: String): String {
    val set = hashSetOf<Char>()
    for (character in s1) set.add(character)
    for (character in s2) if (character in set) return "YES"
    return "NO"
}


//fun twoStrings(s1: String, s2: String): String {
//    val map1 = hashMapOf<Char, Int>()
//    val map2 = hashMapOf<Char, Int>()
//
//    for (character in s1) {
//        map1[character] = (map1[character] ?: 0) + 1
//    }
//
//    for (character in s2) {
//        map2[character] = (map2[character] ?: 0) + 1
//    }
//
//    val keys = if (map1.keys.size > map2.keys.size) map1.keys else map2.keys
//    val keysLooper = if (map1.keys.size > map2.keys.size) map2.keys else map1.keys
//
//
//    for (key in keysLooper) {
//        if (key in keys) return "YES"
//    }
//
//    return "NO"
//}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s1 = readLine()!!

        val s2 = readLine()!!

        val result = twoStrings(s1, s2)

        println(result)
    }
}
