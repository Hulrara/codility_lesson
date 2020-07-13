fun main() {
    println(GenomicRangeQuery().solution("C", intArrayOf(0), intArrayOf(0)).toList())
}

class GenomicRangeQuery {
    fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
        val answerArray = IntArray(P.size){0}
        val aArray = IntArray(S.length + 1) { 0 }
        val cArray = IntArray(S.length + 1) { 0 }
        val gArray = IntArray(S.length + 1) { 0 }

        S.forEachIndexed { index, c ->
            when (c) {
                'A' -> aArray[index + 1]++
                'C' -> cArray[index + 1]++
                'G' -> gArray[index + 1]++
            }
            aArray[index +1] += aArray[index]
            cArray[index +1] += cArray[index]
            gArray[index +1] += gArray[index]
        }


        for (i in P.indices){
            val startIndex = P[i]
            val endIndex = Q[i] + 1
            if(aArray[startIndex] != aArray[endIndex]){
                answerArray[i] = 1
                continue
            }
            if(cArray[startIndex] != cArray[endIndex]){
                answerArray[i] = 2
                continue
            }
            if(gArray[startIndex] != gArray[endIndex]){
                answerArray[i] = 3
                continue
            }
            answerArray[i] = 4
        }
        return answerArray
    }
}