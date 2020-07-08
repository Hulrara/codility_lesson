package codility_lesson

class GenomicRangeQuery {
    fun solution(S: String, P: IntArray, Q: IntArray): IntArray {

        val pair = arrayOf(Pair('A',1),Pair('C',2),Pair('G',3),Pair('T',4))

        for (i in P.indices) {
            val startIndex = P[i]
            val endIndex = Q[i]
            S.substring(startIndex, endIndex + 1)

        }
    }
}