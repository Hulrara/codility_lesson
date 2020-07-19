class Dominator {
    fun solution(A: IntArray): Int {

        val map = HashMap<Int, Int>()
        for (i in A.indices) {
            map[A[i]] = (map[A[i]] ?: 0) + 1
        }
        for (m in map){
            if(m.value > A.size /2){
               return A.indexOf(m.key)
            }
        }
        return  -1
    }
}