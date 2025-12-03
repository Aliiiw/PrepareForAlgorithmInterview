package leet_code

fun containsDuplicate(nums: IntArray): Boolean {
    val numsSetSize = nums.toSet().size
    val numsSize = nums.size

    return (numsSetSize == numsSize).not()
}