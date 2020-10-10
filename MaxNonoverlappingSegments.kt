package codility_lesson

class MaxNonoverlappingSegments {
    fun solution(A: IntArray, B: IntArray): Int {
        var count = 0
        var preLast = -1
        for (i in A.indices) {
            if (preLast < A[i]) {
                count += 1
                preLast = B[i]
            }
        }

        return count
    }
}