package codility_lesson

class TieRopes {
    fun solution(K: Int, A: IntArray): Int {
        var count = 0
        var sum = 0
        A.forEach {
            sum += it
            if (sum >= K) {
                count += 1
                sum = 0
            }
        }
        return count
    }
}