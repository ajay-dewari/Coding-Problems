package array

import jdk.nashorn.internal.objects.Global.println

/**
 * Find the index of a given number n from a given sorted array.
 * play.kotlinlang.org
 */
val sortedArray = arrayOf(2, 4, 5, 7, 9)
val sorted = arrayOf(2)
fun main() {
    println(findGivenNumber(sortedArray, 7))
    println(binearySearch(sorted, 0, sorted.size -1, 2))
}

fun findGivenNumber(array: Array<Int>, n: Int) : Int {
    var start = 0
    var end = array.size - 1

    while(start <= end) {
        var mid = start + (end - start)/2
        if (n == array[mid]) {
            return mid
        }
        if (array[mid] < n) {
            start = mid +1
        } else {
            end = mid - 1
        }
    }
    return -1
}

//issue with the recursive approach is if any condition or logic break we get stackoverflow exception
fun binearySearch(array: Array<Int>, start: Int, end: Int, n: Int): Int {
    var mid = start + (end - start)/2
    if(array[mid] == n) {
        return mid
    }
    if(start > end) {
        return -1
    }

    return if(n > array[mid]) {
        binearySearch(array, end, mid +1, n)
    } else {
        binearySearch(array, mid -1, start, n)
    }

}