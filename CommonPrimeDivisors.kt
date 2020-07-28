fun main() {
    print(
        CommonPrimeDivisors().solution(
            intArrayOf(2, 1, 2),
            intArrayOf(1, 2, 2)
        )
    )
}
//한번더 확인
class CommonPrimeDivisors {
    fun solution(A: IntArray, B: IntArray): Int {
        var answer = 0
        for (i in A.indices) {
            var a = A[i]
            var b = B[i]

            val gcd = GCD(a, b)

            var gcdA = 0
            var gcdB = 0

            while (gcdA != 1) {
                gcdA = GCD(a, gcd)
                a /= gcdA
            }
            while (gcdB != 1) {
                gcdB = GCD(b, gcd)
                b /= gcdB
            }
            if (a == 1 && b == 1) {
                answer += 1
            }

        }
        return answer
    }

    fun GCD(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }
        return GCD(b, a % b)
    }
}