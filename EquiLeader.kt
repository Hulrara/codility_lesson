fun main() {
    print(EquiLeader().solution(intArrayOf(4,3,4,4,4,2)))
}
class EquiLeader {
    fun solution(A: IntArray): Int {

        val map = HashMap<Int, Int>()
        for (i in A.indices) {
            map[A[i]] = (map[A[i]] ?: 0) + 1
        }
        var stand: Int? = null

        for (m in map) {
            if (m.value > A.size / 2) {
                stand = m.key
                break
            }
        }
        if (stand == null) {
            return 0
        }

        var count = 0
        var answer = 0
        for (i in A.indices) {
            if (A[i] == stand) {
                count++
                map[stand] = map[stand]!! - 1
            }
            if (map[stand]!! > (A.size - (i + 1)) / 2 && count > (i + 1) / 2){
                answer++
            }
        }
        return answer
    }
}