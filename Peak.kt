package codility_lesson

fun main() {
    print(Peak().solution(intArrayOf(1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)))
}

class Peak {
    fun solution(A: IntArray): Int {
        val peak = ArrayList<Int>()

        for (p in 1 until A.size - 1) {
            if (A[p - 1] < A[p] && A[p] > A[p + 1]) {
                peak.add(p + 1)
            }
        }

        for (i in peak.size downTo 1) {
            if (A.size % i != 0) {
                continue
            }
            var current = 0
            var count = 1
            while (current < peak.size) {
                val index = count * (A.size / i)

                if (peak[current] <= index) {
                    current += 1
                } else {
                    if (current == 0){
                        break
                    }
                    count += 1
                }
            }
            if (current  == peak.size) {
                return i
            }
        }
        return 0
    }
}