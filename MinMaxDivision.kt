fun main() {
    print(MinMaxDivision().solution(3,5, intArrayOf(5,3)))
}
class MinMaxDivision {
    fun solution(K: Int, M: Int, A: IntArray): Int {
        return binarySearch(A,K)
    }

    fun binarySearch(A: IntArray, K: Int): Int {
        //하나의 원소로 나눴을 경우 , 가장 작은 부분합은 A의 가장 큰 원소
        var low = A.max()?:0
        var high = A.sum()

        if (K == 1) return high
        if (K == A.size) return low
        while (low <= high) {
            val mid = (low + high) / 2

            if (isValidBlock(A, mid, K)) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return low
    }

    fun isValidBlock(A: IntArray, max: Int, K: Int): Boolean {
        var sum = 0
        var blockCnt = 0
        for (i in A) {
            if (sum + i > max) {
                blockCnt += 1
                sum = i
            } else {
                sum += i
            }

            //K개 만큼 or K개 보다 많
            if (blockCnt >= K) {
                return false
            }
        }
        //K개 보다 적게
        return true
    }
}