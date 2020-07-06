fun main() {
//    println(MissingInteger().solution(intArrayOf(1,3,6,4,1,2)))
    println(MissingInteger().solution(intArrayOf(2)))
}

class MissingInteger {
    fun solution(A: IntArray): Int {
        A.sort()

        var count = 0
        A.forEach {  i ->
            if (i <= 0 || i <= count) {
                return@forEach
            }
            count += 1
            if (count != i) {
                return count
            }
        }
        return count + 1
    }
}