package leet_code.array_string.medium

import kotlin.random.Random

class RandomizedSet {

    private val values = ArrayList<Int>()
    private val indexMap = HashMap<Int, Int>()

    fun insert(`val`: Int): Boolean {
        if (indexMap.containsKey(`val`)) return false

        indexMap[`val`] = values.size
        values.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        val idx = indexMap[`val`] ?: return false

        val lastIndex = values.size - 1
        val lastVal = values[lastIndex]

        values[idx] = lastVal
        indexMap[lastVal] = idx

        values.removeAt(lastIndex)
        indexMap.remove(`val`)

        return true
    }

    fun getRandom(): Int {
        val r = Random.nextInt(values.size)
        return values[r]
    }
}
