fun main() {
    print(MaxDoubleSliceSum().solution(intArrayOf(0,10,-5,-2,0)))
}

class MaxDoubleSliceSum {
    fun solution(A: IntArray): Int {
        // write your code in Kotlin
        var result = 0
        val head = IntArray(A.size){0}
        val tail = IntArray(A.size){0}
        for (i in 1 until A.size-1){
            head[i] = Math.max(0,head[i-1] + A[i])
        }
        for (i in A.size-2 downTo 1){
            tail[i] = Math.max(0,tail[i+1] + A[i])
        }
        for (i in 1 until A.size-1){
            result = Math.max(result,head[i-1] + tail[i+1])
        }
        return result
    }

}