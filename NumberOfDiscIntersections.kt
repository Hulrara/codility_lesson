import java.nio.file.LinkOption
import kotlin.math.log2

fun main() {
    print(NumberOfDiscIntersections().solution(intArrayOf(1, 2147483647, 0)))
}
class NumberOfDiscIntersections {
    fun solution(A: IntArray): Int {
        val lower = LongArray(A.size){0}
        val upper = LongArray(A.size){0}
        A.forEachIndexed { index, i ->
            lower[index] = index.toLong() - i
            upper[index] = index.toLong() + i
        }
        lower.sort()
        upper.sort()

        var answer = 0
        var j = 0
        for (i in A.indices) {
            while (j < A.size && upper[i] >= lower[j]) {
                answer += j
                answer -= i
                j++
            }
        }
        if (answer > 10000000) return -1

        return answer
    }
}