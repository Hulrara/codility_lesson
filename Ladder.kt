fun main() {
    print(Ladder().solution(intArrayOf(4,4,5,5,1), intArrayOf(3, 2, 4, 3, 1)).toList())
}

class Ladder {
    lateinit var fibo: IntArray
    fun solution(A: IntArray, B: IntArray): IntArray {

        val answer = IntArray(A.size)
        fibo = IntArray(A.max()!!+1) { -1 }
        fibo[0] = 1
        fibo[1] = 1


        for (i in 2..A.max()!!){
            fibo[i] = (fibo[i-1] + fibo[i-2]) % Math.pow(2.toDouble(),30.toDouble()).toInt()
        }
        for (i in A.indices) {
            answer[i] = fibo[A[i]] % Math.pow(2.toDouble(), B[i].toDouble()).toInt()
        }

        return answer
    }

    fun solve(n: Int): Int {
        println(n)
        if (fibo[n] != -1) {
            return fibo[n]
        }
        val ret=  (solve(n - 2) + solve(n - 1)) % Math.pow(2.toDouble(),30.toDouble()).toInt()
        fibo[n] = ret
        return ret
    }
}
