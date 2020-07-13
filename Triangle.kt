fun main(){
    print((Triangle().solution(intArrayOf(10,50,5,1))))
}
class Triangle {
    fun solution(A: IntArray): Int {
        // write your code in Kotlin

        val list = A.map { it.toLong() }.sorted()
        for (i in 0 until list.size-2){
            if (list[i] + list[i+1] > list[i+2]){
                return 1
            }
        }
        return 0
    }
}