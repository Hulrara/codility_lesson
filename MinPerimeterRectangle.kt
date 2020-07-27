package codility_lesson

class MinPerimeterRectangle {
    fun solution(N: Int): Int {
        for (a in Math.sqrt(N.toDouble()).toInt() downTo 1) {
            if (N % a == 0) {
                val b = N / a
                return 2 * (a + b)
            }
        }
        return 0
    }
}