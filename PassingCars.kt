fun main() {
    print(PassingCars().solution(intArrayOf(1, 1, 1, 1, 1)))
}

class PassingCars {
    fun solution(A: IntArray): Int {
        var answer = 0

        val cache = IntArray(A.size) { 0 }

        for (i in 1 until cache.size) {
            cache[i] = cache[i - 1]
            if (A[i] == 1) {
                cache[i] += 1
            }
        }

        A.forEachIndexed { index, i ->
            if (i == 0) {
                answer += cache.last() - cache[index]
                if (answer > 1000000000) {
                    return -1
                }
            }
        }
        // write your code in Kotlin
        return answer
    }

    fun solution2(A: IntArray): Int {
        var answer = 0

        var stand = 0
        A.forEach {
            if (it == 0) {
                stand += 1
            } else {
                answer += stand
                if (answer > 1000000000) {
                    return -1
                }
            }
        }
        // write your code in Kotlin
        return answer
    }
}