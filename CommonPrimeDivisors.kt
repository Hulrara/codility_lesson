class CommonPrimeDivisors {
    fun solution(A: IntArray, B: IntArray): Int {

        for (i in A.indices) {
            val a = A[i]
            val b = B[i]

            val GCD = gcd(a, b)
            val check = a * b / GCD
            val max = Math.max(a,b)
            if ( max > check ) {
                val div = max/check
                if (b%div != 0){
                    continue
                }
            }
            return  i
        }
        return -1
    }

    fun gcd(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }
        return gcd(b, a % b)
    }
}