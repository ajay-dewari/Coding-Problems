package array_manipulation

fun main() {
    println(separate0and1(arrayOf(1, 0, 1, 0, 1, 0)).contentToString())
    println(segregate0and1(arrayOf(1, 0, 1, 0, 1, 0)).contentToString())
}

fun separate0and1(array: Array<Int>): Array<Int> {
    var i = 0
    var j = array.size - 1
    while (i < j) {
        if (array[i] == 0) {
            i++
        } else {
            if (array[j] == 0) {
                val temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }
            j--
        }
    }
    return array
}

fun segregate0and1(array: Array<Int>): Array<Int> {
    var j = -1
    array.forEachIndexed { index, i ->
        if (i == 0) {
            j++
            val temp = array[index]
            array[index] = array[j]
            array[j] = temp
        }
    }
    return array
}