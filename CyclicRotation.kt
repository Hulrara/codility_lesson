import java.util.*

fun main() {
    print(CyclicRotation().solution(intArrayOf(), 0).toList())
}

class CyclicRotation {
    fun solution(A: IntArray, K: Int): IntArray {
        if(A.isEmpty()){
            return A
        }
        var _K = K % A.size

        val deque: ArrayDeque<Int> = ArrayDeque<Int>(A.toMutableList())

        while (_K > 0) {
            val last = deque.removeLast()
            _K--
            deque.addFirst(last)
        }
        return deque.toIntArray()
    }
}