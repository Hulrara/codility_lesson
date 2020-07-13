fun main() {
    print(MinAvgTwoSlice().solution(intArrayOf(4, 2, 2, 5, 1, 5, 8)))
}

class MinAvgTwoSlice {
    fun solution(A: IntArray): Int {
        var min = (A[0] + A[1]) / 2f
        var answer = 0


        for (i in 2 until A.size) {
            var avg = (A[i] + A[i - 1]) / 2f
            if (avg < min) {
                min = avg
                answer = i - 1
            }

            avg = (A[i] + A[i - 1] + A[i - 2]) / 3f
            if (avg < min) {
                min = avg
                answer = i - 2
            }
        }
        return answer
    }
}