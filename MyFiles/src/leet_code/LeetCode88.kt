package leet_code

fun main() {

    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val m = 3
    val nums2 = intArrayOf(2, 5, 6)
    val n = 3

    merge(nums1, m, nums2, n)

}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var i = m - 1
    var j = n - 1
    var k = m + n - 1

    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i]
            i--
        } else {
            nums1[k] = nums2[j]
            j--
        }
        k--
    }

    while (j >= 0) {
        nums1[k] = nums2[j]
        k--
        j--
    }

    print(nums1.contentToString())
}