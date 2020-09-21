import kotlin.math.abs

fun main() {
    print(MinAbsSumOfTwo().solution(intArrayOf(-100, -99, -80, -70, -77, -55, -66, 55)))
}

class MinAbsSumOfTwo {
    fun solution(A: IntArray): Int {
        val distinctArr = A.distinct().sorted()
        var min = Int.MAX_VALUE
        val absSum = distinctArr.minBy { Math.abs(it) }?.let { Math.abs(it + it) } ?: 0

        var start = 0
        var back = distinctArr.size - 1
        while (start < back) {
            min = Math.min(min, Math.abs(distinctArr[start] + distinctArr[back]))
            if (Math.abs(distinctArr[start]) > Math.abs(distinctArr[back])) {
                start += 1
            } else {
                back -= 1
            }
        }
        return Math.min(min, absSum)
    }
}