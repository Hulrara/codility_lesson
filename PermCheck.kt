fun main() {
    print(PermCheck().solution(intArrayOf(2, 3, 4, 1)))
    print(PermCheck().solution(intArrayOf(2)))
}

class PermCheck {
    fun solution(A: IntArray): Int {
        A.sort()
        var last = 0
        A.forEach {
            if (it != last + 1) {
                return 0
            }
            last = it
        }
        return 1
    }
}