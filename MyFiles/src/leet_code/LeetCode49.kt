package leet_code


fun groupAnagrams(strings: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()

    for (s in strings) {
        val array = s.toCharArray()
        array.sort()
        val sortedString = String(array)

        if (map.containsKey(sortedString).not()) {
            map[sortedString] = ArrayList()
        }
        map[sortedString]?.add(s)
    }
    return ArrayList(map.values)
}
