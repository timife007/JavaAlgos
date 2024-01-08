package algoexpert

class QuickSort {

    fun mergeSort(array: MutableList<Int>): List<Int> {
        // Write your code here.
        val start = 0
        val end = array.size - 1
        return sort(array, start, end)
    }
    private fun sort(array: MutableList<Int>, start: Int, end : Int): List<Int>{
        if(start < end){
            val mid = (start + end) / 2
            sort(array, start, mid)
            sort(array, mid + 1, end)
            merge(array, start, mid, end)
        }

        return array
    }

    private fun merge(array: MutableList<Int>, start: Int, mid: Int, end: Int){

        var tracker = start
        val l1 = mid - start + 1
        val l2 = end - mid
        val leftArray = Array(l1){0}
        val rightArray = Array(l2){0}
        for(i in 0 until l1){
            leftArray[i] = array[start + i]
        }
        for(j in 0 until l2){
            rightArray[j] = array[mid + j + 1]
        }

        var left = 0
        var right = 0

        while(left < l1 && right < l2){
            if(leftArray[left] <= rightArray[right]){
                array[tracker] = leftArray[left]
                left++
            }else {
                array[tracker] = rightArray[right]
                right++
            }
            tracker++
        }

        while(left < l1){
            array[tracker] = leftArray[left]
            left++
            tracker++
        }

        while(right < l2){
            array[tracker] = rightArray[right]
            right++
            tracker++
        }
    }

}

fun main(){
    val sort = QuickSort()
    val input = mutableListOf(5,6,4,3,2,1)
    println(sort.mergeSort(input))
}