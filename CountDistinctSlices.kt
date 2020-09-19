import kotlin.reflect.jvm.internal.impl.util.Check

fun main() {
    print(CountDistinctSlices().solution(6, intArrayOf( 3, 4, 5, 5, 2)))
}

class CountDistinctSlices {
    fun solution(M: Int, A: IntArray): Int {
        var answer = 0
        var check = MutableList(M + 1) { false }
        var front = 0

        for (back in A.indices) {
            while (front < A.size && !check[A[front]]) {
                check[A[front]] = true
                answer += front - back + 1
                front += 1
                if(answer >= 1000000000)  return 1000000000
            }
            check[A[back]] = false
        }
        return answer
    }
}
