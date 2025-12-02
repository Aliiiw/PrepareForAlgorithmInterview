package leet_code
fun reverseString(s: CharArray): Unit {
    val result = mutableListOf<String>()
    for(i in s.size - 1 downTo 0) {
        result.add(s[i].toString())
    }
    println(result)
}

//fun leet_code.reverseString(s: CharArray): Unit {
//    var left = 0
//    var right = s.size - 1
//
//    while (left < right) {
//        val temp = s[left]
//        s[left] = s[right]
//        s[right] = temp
//        left++
//        right--
//    }
//}
//