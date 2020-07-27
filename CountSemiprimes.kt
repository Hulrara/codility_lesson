import kotlin.concurrent.fixedRateTimer

fun main() {
    print(CountSemiprimes().solution(26, intArrayOf(1, 4, 16), intArrayOf(26, 10, 20)).toList())
}

class CountSemiprimes {
    fun solution(N: Int, P: IntArray, Q: IntArray): IntArray {
        val cache = BooleanArray(N + 1) { false }
        val semiprime = IntArray(N + 1) { 0 }
        val answer = IntArray(P.size) { 0 }
        for (i in 2..N) {
            var isPrime = true
            for (j in 2..Math.sqrt(i.toDouble()).toInt()) {
                if (i % j == 0) {
                    isPrime = false
                    break
                }
            }
            cache[i] = isPrime
        }

        var count = 0
        for (i in 1..N) {
            for (j in Math.sqrt(i.toDouble()).toInt() downTo 2) {
                if (i % j == 0 && cache[j] && cache[i / j]) {
                    count += 1
                    break
                }
            }
            semiprime[i] = count
        }
        for (i in P.indices) {
            answer[i] = semiprime[Q[i]] - semiprime[P[i]-1]
        }
        return answer
    }
}