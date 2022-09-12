package searching

/**
 * Find the index of a given number n in a given sorted array.
 * In case the given number n is not available in the given array return -1
 *
 * I/P: [2, 4, 5, 7, 9], 7
 * O/P: 3
 *
 * I/P: [0, 7, 9, 11], 7
 * O/P: 1
 *
 * I/P: [3, 5, 6, 11], 7
 * O/P: -1
 *
 */
val sortedArray = arrayOf(2, 4, 5, 7, 9)
val sorted = arrayOf(2)
fun main() {
    println(binarySearchIterative(sortedArray, 7))
    println(binarySearch(sorted, 0, sorted.size - 1, 2))
}

fun binarySearchIterative(array: Array<Int>, n: Int): Int {
    var start = 0
    var end = array.size - 1

    while (start <= end) {
        val mid = start + (end - start) / 2
        if (n == array[mid]) {
            return mid
        }
        if (n > array[mid]) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return -1
}


fun binarySearch(array: Array<Int>, start: Int, end: Int, n: Int): Int {
    if (start > end) {
        return -1
    }
    var mid = start + (end - start) / 2
    return if (array[mid] == n) {
        mid
    } else if (n > array[mid]) {
        binarySearch(array, mid + 1, end, n)
    } else {
        binarySearch(array, start, mid - 1, n)
    }
}