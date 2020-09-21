class CountTriangles {
    fun solution(A: IntArray): Int {
        A.sort()
        var answer =0
        for (p in 0 until  A.size -2){
            for (q in p+1 until A.size - 1){
                var r = q+1
                while (r < A.size && A[p] + A[q] > A[r]){
                    answer+=1
                    r+=1
                }
            }
        }
        return answer
    }
}