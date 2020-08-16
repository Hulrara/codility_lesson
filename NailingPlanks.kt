fun main() {
    println(NailingPlanks().solution(intArrayOf(1, 4, 5, 8), intArrayOf(4, 5, 9, 10), intArrayOf(4, 6, 7, 10, 2)))

    println(
        NailingPlanks().solution(
            intArrayOf(1, 4, 7, 10, 12),
            intArrayOf(3, 6, 9, 12, 14),
            intArrayOf(12, 2, 5, 8)
        )
    )
}

class NailingPlanks {
    fun solution(A: IntArray, B: IntArray, C: IntArray): Int {
        val AtoB = A.zip(B)
        val CtoIndex = C.zip(C.indices).sortedBy { it.first }

        var result = -1
        for (zip in AtoB) {
            result = minNailedValue(zip, C.sortedArray(), CtoIndex,result)
            if (result==-1){
                return -1
            }
        }
        return result + 1
    }

    fun minNailedValue(AtoB: Pair<Int, Int>, C: IntArray, CtoIndex: List<Pair<Int, Int>>, before: Int): Int {
        var low = AtoB.first
        var high = AtoB.second

        while (low <= high) {
            val mid = (low + high) / 2
            if (C.firstOrNull { it in low..mid } != null){
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        if (low > AtoB.second) {
            return -1
        }
        var pos = CtoIndex.indexOfFirst { it.first == low }
        var result = Int.MAX_VALUE
        var value = low


        while (value <= AtoB.second && pos < CtoIndex.size) {
            val index = CtoIndex[pos].second
            if (index <= before) {
                return before
            }
            result = Math.min(result, index)
            pos++
            if (pos < CtoIndex.size) {
                value = CtoIndex[pos].first
            }
        }
        return result
    }

}