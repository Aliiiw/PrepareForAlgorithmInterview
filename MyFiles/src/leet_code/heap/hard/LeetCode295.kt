package leet_code.heap.hard

import java.util.*


/**
The median is the middle value in an ordered integer list. If the size of the list is even,
there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */

class MedianFinder {
    private val low = PriorityQueue<Int>(compareByDescending { it })
    private val high = PriorityQueue<Int>()

    fun addNum(num: Int) {
        low.add(num)
        high.add(low.poll())

        if (low.size < high.size) {
            low.add(high.poll())
        }
    }

    fun findMedian(): Double {
        return if (low.size == high.size) {
            (low.peek().toLong() + high.peek().toLong()) / 2.0
        } else {
            low.peek().toDouble()
        }
    }
}

