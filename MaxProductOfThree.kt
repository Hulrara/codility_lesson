fun main() {
    print(MaxProductOfThree().solution(intArrayOf(-2, -3, -5, -6, 0)))
}

class MaxProductOfThree {
    fun solution(A: IntArray): Int {
        // write your code in Kotlin
        val sortedList = A.sorted()

        var answer = sortedList.takeLast(3).fold(1) { acc, i ->
            acc * i
        }

        if (sortedList[0] <= 0 && sortedList[1] <= 0 && sortedList.last() > 0) {
            answer = Math.max(answer, sortedList[0] * sortedList[1] * sortedList.last())
        }
        return answer
    }
}