package common.searching

/**
 * Find the index of a given number n in a given sorted common.array which is rotated.
 * In case the given number n is not available in the given common.array return -1
 *
 * I/P: [7, 9, 2, 4, 5], 7
 * O/P: 0
 *
 * I/P: [16, 19, 0, 7, 9, 11], 7
 * O/P: 3
 *
 * I/P: [5, 6, 11, 3], 7
 * O/P: -1
 *
 */

val rotatedSortArray = arrayOf(2, 4, 5, 7, 9)

fun main() {
    println(findIndexInRotatedSortedArray(rotatedSortArray, 7))
}

fun findIndexInRotatedSortedArray(array: Array<Int>, n: Int): Int {
    var startIndex = 0
    var endIndex = array.size - 1

    while (startIndex <= endIndex) {
        val mid = startIndex + (endIndex - startIndex) / 2
        if (array[mid] == n) {
            return mid
        }

        if (array[startIndex] < array[mid]) {
            if (n >= array[startIndex] && n < array[mid]) {
                endIndex = mid - 1
            } else {
                startIndex = mid + 1
            }
        } else {
            if (n < array[endIndex] && n > array[mid]) {
                startIndex = mid + 1
            } else {
                endIndex = mid - 1
            }
        }

        /*if (common.array[mid] > n) {
            endIndex = mid - 1
        } else {
            startIndex = mid + 1
        }*/
    }
    return -1
}