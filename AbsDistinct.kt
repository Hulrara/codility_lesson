class AbsDistinct {
    fun solution(A: IntArray): Int {
        // write your code in Kotlin
       return A.map { Math.abs(it) }
            .distinct()
            .count()
    }
}