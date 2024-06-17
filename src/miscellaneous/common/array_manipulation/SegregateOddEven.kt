package miscellaneous.common.array_manipulation

fun segregateOddEven(array: Array<Int>) {
    var i = 0;
    var j = array.size - 1

    while (i < j) {
        if (array[i] % 2 == 0) {
            i++
        } else {
            if (array[j] % 2 == 0) {
                val temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }
            j--
        }
    }
}

fun separateOddEven(array: Array<Int>): Array<Int> {
    var j = -1
    array.forEachIndexed { index, i ->
        if (array[j] % 2 == 0) {
            j++
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }
    }
    return array
}