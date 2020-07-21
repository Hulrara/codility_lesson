fun main() {
    print(MaxSliceSum().solution(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
}
class MaxSliceSum {
    fun solution(A: IntArray): Int {
        var localMax = A[0]
        var globalMax = A[0]
        for (i in 1 until A.size){
            localMax = Math.max(A[i],localMax+A[i])
            globalMax = Math.max(globalMax,localMax)
        }
        return globalMax
    }
}