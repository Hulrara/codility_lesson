fun main() {
    print(MaxCounters().solution(5, intArrayOf(3, 4, 4, 6, 1, 4, 4)).toList())
}

class MaxCounters {
    fun solution(N: Int, A: IntArray): IntArray {
        val answer = IntArray(N) { 0 }
        var tempMax = 0
        var lastMax = 0
        A.forEach { i ->
            if (i == N + 1) {
                lastMax = tempMax
            } else {
                answer[i - 1] = Math.max(answer[i - 1], lastMax) + 1
                tempMax = Math.max(answer[i-1],tempMax)
            }
        }
        answer.forEachIndexed { index, i ->
            if (i < lastMax)
                answer[index] = lastMax
        }
        return answer
    }
}