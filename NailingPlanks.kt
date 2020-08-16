fun main() {
    println(NailingPlanks().solution(intArrayOf(1, 4, 5, 8), intArrayOf(4, 5, 9, 10), intArrayOf(4, 6, 7, 10, 2)))
}

class NailingPlanks {
    fun solution(A: IntArray, B: IntArray, C: IntArray): Int {
        val AtoB = A.zip(B)
        val CtoIndex = C.zip(C.indices).sortedBy { it.first }

        var result = -1
        for (zip in AtoB) {
            result = minNailedValue(zip, CtoIndex, result)
            if (result == -1) {
                return -1
            }
        }
        return result + 1
    }

    fun minNailedValue(AtoB: Pair<Int, Int>, CtoIndex: List<Pair<Int, Int>>, before: Int): Int {
        val len = CtoIndex.size
        var low = 0
        var high = len - 1
        //lower bound 로 박을 수 있는 못중 가장 작은 index 찾기
        while (low <= high) {
            val mid = (low + high) / 2
            val key = CtoIndex[mid].first
            when {
                key < AtoB.first -> {
                    low = mid + 1
                }
                key > AtoB.second -> {
                    high = mid - 1
                }
                else -> {
                    high = mid - 1
                }
            }
        }

        if (low >= len) {
            return -1
        }
        var value = CtoIndex[low].first

        if (value > AtoB.second) {
            return -1
        }
        var result = Int.MAX_VALUE

        // 박을 수 있은 못 중 가장 작은 index 찾기
        while (value <= AtoB.second && low < len) {
            val index = CtoIndex[low].second
            if (index <= before) {
                return before
            }
            result = Math.min(result, index)
            low += 1
            if (low < len) {
                value = CtoIndex[low].first
            }
        }
        return result
    }
}