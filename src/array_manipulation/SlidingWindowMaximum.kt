package array_manipulation


/**
 *You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
 *the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
 *by one position.
 *
 *Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 *
 *Example 2:
 *
 *Input: nums = [1], k = 1
 * Output: [1]
 **/

fun slidingWindowMaximum(array: Array<Int>, k: Int): Array<Int> {
    val endIndex = array.size - k
    var solution = arrayOf<Int>()
    for (i in 0..endIndex) {
        solution[i] = getMaxElement(array, i, i+(k-1))
    }
    return solution
}


fun getMaxElement(array: Array<Int>, start: Int, end: Int): Int {
    var max = Integer.MIN_VALUE
    for (j in start..end) {
        max = Math.max(array[j], max)
    }
    return max
}


fun main() {

    println(slidingWindowMaximum(arrayOf(1,3,-1,-3,5,3,6,7), 3).contentToString())

}

