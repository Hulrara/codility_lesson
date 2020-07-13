import java.util.*

fun main() {
    print(StoneWall().solution(intArrayOf(8, 8, 5, 7, 9, 8, 7, 4, 8)))
}

class StoneWall {
    fun solution(H: IntArray): Int {
        val stack = Stack<Int>()
        var answer = 0

        H.forEach {
            while (stack.isNotEmpty() && it < stack.peek() ) {
                stack.pop()
            }
            if (stack.isEmpty() || it > stack.peek()) {
                stack.push(it)
                answer+=1
            }
        }
        return answer
    }
}