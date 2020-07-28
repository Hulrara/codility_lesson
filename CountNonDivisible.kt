fun main() {
    print(CountNonDivisible().solution(intArrayOf(3, 1, 2, 3, 6)).toList())
}

class CountNonDivisible {
    fun solution(A: IntArray): IntArray {
        val cache = IntArray((A.size * 2) + 1) { -1 }
        val numCnt = IntArray((A.size * 2) + 1) { 0 }
        val answer = IntArray(A.size) { 0 }

        A.forEach {
            numCnt[it]++
        }

        for (i in A.indices) {
            val stand = A[i]
            if (cache[stand] != -1) {
                continue
            }
            var divisor = 0
            for (j in 1..Math.sqrt(stand.toDouble()).toInt()) {
                if (stand % j == 0) {
                    divisor += numCnt[j]
                    if (stand > j * j) {
                        divisor += numCnt[stand/j]
                    }
                }
            }
            cache[stand] = A.size - divisor
        }
        A.forEachIndexed { index, i ->
            answer[index] = cache[i]
        }
        return answer
    }
}