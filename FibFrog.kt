import java.util.*
import kotlin.collections.ArrayList

fun main() {
    print(FibFrog().solution(intArrayOf(0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0)))
    print(FibFrog().solution(intArrayOf()))
}

class FibFrog {

    fun solution(A: IntArray): Int {
        val fibo = ArrayList<Int>()
        fibo.add(0)
        fibo.add(1)

        var idx = 2
        val check = BooleanArray(A.size + 1) { false }
        do {
            fibo.add(fibo[idx - 1] + fibo[idx - 2])
            idx += 1
        } while (fibo[idx - 1] <= A.size + 1)

        val sortFibo = fibo.sortedDescending()
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(-1, 0))

        while (queue.isNotEmpty()) {
            val peek = queue.poll()

            for (f in sortFibo) {
                val next = peek.first + f

                if (next == A.size) {
                    return peek.second + 1
                } else if (next < A.size && next >= 0) {
                    if (A[next] == 1 && !check[next]) {
                        check[next] = true
                        queue.add(Pair(next, peek.second + 1))
                    }
                }
            }
        }
        return -1
    }
}