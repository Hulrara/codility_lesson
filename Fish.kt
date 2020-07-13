import java.util.*

fun main() {
    print(Fish().solution(intArrayOf(0,1), intArrayOf(1,1)))
}

class Fish {
    fun solution(A: IntArray, B: IntArray): Int {
        var answer = 0
        val downStack = Stack<Int>()

        B.forEachIndexed { index, i ->
            if (i == 1) {
                downStack.push(A[index])
            } else {
                while (downStack.isNotEmpty()) {
                    if (A[index] > downStack.peek()) {
                        downStack.pop()
                    } else {
                        break
                    }
                }
                if (downStack.isEmpty()) {
                    answer += 1
                }
            }
        }
        return answer + downStack.size
    }
}